package com.beimin.eveapi.response.pilot;

import com.beimin.eveapi.model.shared.Contact;
import com.beimin.eveapi.model.shared.ContactLabel;
import com.beimin.eveapi.response.shared.AbstractContactListResponse;
import java.util.Set;

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

    @Override
    public Set<ContactLabel> getContactLabels() {
        return super.getContactLabels();
    }

    @Override
    public Set<Contact> getContactList() {
        return super.getContactList();
    }
}
