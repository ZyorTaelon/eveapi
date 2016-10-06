package com.beimin.eveapi.handler.shared;

import com.beimin.eveapi.model.shared.ContactLabel;
import com.beimin.eveapi.model.shared.ContactLabelList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.handler.AbstractContentHandler;
import com.beimin.eveapi.model.shared.Contact;
import com.beimin.eveapi.model.shared.ContactList;
import com.beimin.eveapi.response.shared.AbstractContactListResponse;

public class ContactListHandler<CLR extends AbstractContactListResponse> extends AbstractContentHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(ContactListHandler.class);

    private final Class<CLR> clazz;
    private CLR response;
    private ContactList contactList;
    private ContactLabelList labelList;

    public ContactListHandler(Class<CLR> clazz) {
        this.clazz = clazz;
    }

    @Override
    public void startDocument() throws SAXException {
        try {
            response = clazz.newInstance();
        } catch (InstantiationException e) {
            LOGGER.error("Couldn't start document", e);
        } catch (IllegalAccessException e) {
            LOGGER.error("Couldn't start document", e);
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attrs) throws SAXException {
        if (ELEMENT_ROWSET.equals(qName)) {
            // contacts or labels, separate by key
            if (getString(attrs, "key").equals("contactID")) {
                contactList = new ContactList();
                contactList.setName(getString(attrs, "name"));
            } else {
                labelList = new ContactLabelList();
                labelList.setName(getString(attrs, "name"));
            }
        }

        if (ELEMENT_ROW.equals(qName)) {
            // contacts or labels, separate by index
            if (attrs.getIndex("contactID") > -1) {
                Contact contact = new Contact();
                contact.setContactID(getInt(attrs, "contactID"));
                contact.setContactName(getString(attrs, "contactName"));
                contact.setInWatchlist(getBoolean(attrs, "inWatchlist"));
                contact.setStanding(getDouble(attrs, "standing"));
                contact.setContactTypeID(getInt(attrs, "contactTypeID"));
                contact.setLabelMask(getInt(attrs, "labelMask"));
                contactList.add(contact);
            } else {
                ContactLabel label = new ContactLabel();
                label.setLabelID(getInt(attrs, "labelID"));
                label.setName(getString(attrs, "name"));
                labelList.add(label);
            }
        }
        super.startElement(uri, localName, qName, attrs);
        accumulator.setLength(0);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (ELEMENT_ROWSET.equals(qName)) {
            if (contactList != null) {
                response.add(contactList);
                contactList = null;
            } else {
                response.add(labelList);
                labelList = null;
            }
        }
        super.endElement(uri, localName, qName);
    }

    @Override
    public CLR getResponse() {
        return response;
    }
}