package com.beimin.eveapi.handler.shared;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.handler.AbstractContentHandler;
import com.beimin.eveapi.model.shared.Contact;
import com.beimin.eveapi.model.shared.ContactLabel;
import com.beimin.eveapi.model.shared.NamedList;
import com.beimin.eveapi.response.shared.AbstractContactListResponse;

public class ContactListHandler<CLR extends AbstractContactListResponse> extends AbstractContentHandler<CLR> {
    private static final String ATTRIBUTE_CONTACT_ID = "contactID";

    private static final Logger LOGGER = LoggerFactory.getLogger(ContactListHandler.class);

    private final Class<CLR> clazz;
    private NamedList<Contact> contactList;
    private NamedList<ContactLabel> labelList;

    public ContactListHandler(final Class<CLR> clazz) {
        this.clazz = clazz;
    }

    @Override
    public void startDocument() throws SAXException {
        try {
            setResponse(clazz.newInstance());
        } catch (final InstantiationException e) {
            LOGGER.error("Couldn't start document", e);
        } catch (final IllegalAccessException e) {
            LOGGER.error("Couldn't start document", e);
        }
    }

    @Override
    protected void elementStart(final String uri, final String localName, final String qName, final Attributes attrs) throws SAXException {
        if (ELEMENT_ROWSET.equals(qName)) {
            // contacts or labels, separate by key
            if (ATTRIBUTE_CONTACT_ID.equals(getString(attrs, "key"))) {
                contactList = new NamedList<>();
                contactList.setName(getString(attrs, ATTRIBUTE_NAME));
            } else {
                labelList = new NamedList<>();
                labelList.setName(getString(attrs, ATTRIBUTE_NAME));
            }
        }

        if (ELEMENT_ROW.equals(qName)) {
            // contacts or labels, separate by index
            if (attrs.getIndex(ATTRIBUTE_CONTACT_ID) > -1) {
                final Contact contact = new Contact();
                contact.setContactID(getInt(attrs, ATTRIBUTE_CONTACT_ID));
                contact.setContactName(getString(attrs, "contactName"));
                contact.setInWatchlist(getBoolean(attrs, "inWatchlist"));
                contact.setStanding(getDouble(attrs, "standing"));
                contact.setContactTypeID(getInt(attrs, "contactTypeID"));
                contact.setLabelMask(getLong(attrs, "labelMask"));
                contactList.add(contact);
            } else {
                final ContactLabel label = new ContactLabel();
                label.setLabelID(getLong(attrs, "labelID"));
                label.setName(getString(attrs, "name"));
                labelList.add(label);
            }
        }
    }

    @Override
    protected void elementEnd(final String uri, final String localName, final String qName) throws SAXException {
        final CLR response = getResponse();
        if (ELEMENT_ROWSET.equals(qName)) {
            if (contactList != null) {
                response.add(contactList);
                contactList = null;
            } else {
                response.addLabels(labelList);
                labelList = null;
            }
        }
    }
}
