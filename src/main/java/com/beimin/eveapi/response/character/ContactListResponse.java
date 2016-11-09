package com.beimin.eveapi.response.character;

import java.util.List;

import com.beimin.eveapi.model.shared.Contact;
import com.beimin.eveapi.model.shared.ContactLabel;
import com.beimin.eveapi.response.shared.AbstractContactListResponse;

public class ContactListResponse extends AbstractContactListResponse {

    @Override
    public List<ContactLabel> getAllianceContactLabels() {
        return super.getAllianceContactLabels();
    }

    @Override
    public List<Contact> getAllianceContactList() {
        return super.getAllianceContactList();
    }

    @Override
    public List<ContactLabel> getCorporateContactLabels() {
        return super.getCorporateContactLabels();
    }

    @Override
    public List<Contact> getCorporateContactList() {
        return super.getCorporateContactList();
    }

    @Override
    public List<ContactLabel> getContactLabels() {
        return super.getContactLabels();
    }

    @Override
    public List<Contact> getContactList() {
        return super.getContactList();
    }
}
