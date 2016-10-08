package com.beimin.eveapi.response.corporation;

import com.beimin.eveapi.model.shared.Contact;
import com.beimin.eveapi.model.shared.NamedList;
import com.beimin.eveapi.response.shared.AbstractContactListResponse;

public class ContactListResponse extends AbstractContactListResponse {
    public NamedList<Contact> getCorporateContactList() {
        return contactLists.get("corporateContactList");
    }

    public NamedList<Contact> getAllianceContactList() {
        return contactLists.get("allianceContactList");
    }

}
