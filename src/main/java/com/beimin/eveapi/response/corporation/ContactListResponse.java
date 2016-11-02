package com.beimin.eveapi.response.corporation;

import java.util.Set;

import com.beimin.eveapi.model.shared.Contact;
import com.beimin.eveapi.model.shared.ContactLabel;
import com.beimin.eveapi.response.shared.AbstractContactListResponse;

public class ContactListResponse extends AbstractContactListResponse {

    @Override
    public Set<ContactLabel> getAllianceContactLabels() {
        return super.getAllianceContactLabels();
    }

    @Override
    public Set<Contact> getAllianceContactList() {
        return super.getAllianceContactList();
    }

    @Override
    public Set<ContactLabel> getCorporateContactLabels() {
        return super.getCorporateContactLabels();
    }

    @Override
    public Set<Contact> getCorporateContactList() {
        return super.getCorporateContactList();
    }
}
