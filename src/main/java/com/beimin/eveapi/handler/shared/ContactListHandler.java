package com.beimin.eveapi.handler.shared;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.handler.AbstractContentHandler;
import com.beimin.eveapi.model.shared.Contact;
import com.beimin.eveapi.model.shared.ContactLabel;
import com.beimin.eveapi.response.shared.AbstractContactListResponse;

public class ContactListHandler<CLR extends AbstractContactListResponse> extends AbstractContentHandler<CLR> {
    private static final String ATTRIBUTE_CONTACT_ID = "contactID";

    private String rowsetName;

    public ContactListHandler(final CLR clr) {
        super(clr);
    }

    @Override
    protected void elementStart(final String uri, final String localName, final String qName, final Attributes attrs) throws SAXException {
        if (ELEMENT_ROWSET.equals(qName)) {
            rowsetName = getString(attrs, ATTRIBUTE_NAME);
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
        label.setName(getString(attrs, ATTRIBUTE_NAME));
        return label;
    }
}
