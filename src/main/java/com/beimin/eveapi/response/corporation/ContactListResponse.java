package com.beimin.eveapi.response.corporation;

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
}
