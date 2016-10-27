package com.beimin.eveapi.handler.shared;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.handler.AbstractContentHandler;
import com.beimin.eveapi.model.shared.Contact;
import com.beimin.eveapi.model.shared.ContactLabel;
import com.beimin.eveapi.response.shared.AbstractContactListResponse;

public class ContactListHandler<CLR extends AbstractContactListResponse> extends AbstractContentHandler<CLR> {
    private static final String ATTRIBUTE_CONTACT_ID = "contactID";

    private static final Logger LOGGER = LoggerFactory.getLogger(ContactListHandler.class);

    private final Class<CLR> clazz;
    private String rowsetName;

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
            rowsetName = getString(attrs, "name");
        } else if (ELEMENT_ROW.equals(qName)) {
            if ("contactList".equals(rowsetName)) {
                getResponse().addContact(getContact(attrs));
            } else if ("contactLabels".equals(rowsetName)) {
                getResponse().addContactLabel(getContactLabel(attrs));
            } else if ("corporateContactList".equals(rowsetName)) {
                getResponse().addCorporateContact(getContact(attrs));
            } else if ("corporateContactLabels".equals(rowsetName)) {
                getResponse().addCorporateContactLabel(getContactLabel(attrs));
            } else if ("allianceContactList".equals(rowsetName)) {
                getResponse().addAllianceContact(getContact(attrs));
            } else if ("allianceContactLabels".equals(rowsetName)) {
                getResponse().addAllianceContactLabel(getContactLabel(attrs));
            }
        }
    }

    private Contact getContact(final Attributes attrs) {
        final Contact contact = new Contact();
        saveAttributes(Contact.class, attrs);
        contact.setContactID(getInt(attrs, ATTRIBUTE_CONTACT_ID));
        contact.setContactName(getString(attrs, "contactName"));
        contact.setInWatchlist(getBoolean(attrs, "inWatchlist"));
        contact.setStanding(getDouble(attrs, "standing"));
        contact.setContactTypeID(getInt(attrs, "contactTypeID"));
        contact.setLabelMask(getLong(attrs, "labelMask"));
        return contact;
    }

    private ContactLabel getContactLabel(final Attributes attrs) {
        final ContactLabel label = new ContactLabel();
        saveAttributes(ContactLabel.class, attrs);
        label.setLabelID(getLong(attrs, "labelID"));
        label.setName(getString(attrs, "name"));
        return label;
    }
}
