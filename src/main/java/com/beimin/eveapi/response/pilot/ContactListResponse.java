package com.beimin.eveapi.response.pilot;

import com.beimin.eveapi.model.shared.ContactLabelList;
import com.beimin.eveapi.model.shared.ContactList;
import com.beimin.eveapi.response.shared.AbstractContactListResponse;

public class ContactListResponse extends AbstractContactListResponse {
    public ContactList getContactList() {
        return contactLists.get("contactList");
    }

    public ContactLabelList getContactLabelList() {
        return labelLists.get("contactLabels");
    }

}