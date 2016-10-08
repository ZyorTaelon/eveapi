package com.beimin.eveapi.response.pilot;

import com.beimin.eveapi.model.shared.Contact;
import com.beimin.eveapi.model.shared.ContactLabel;
import com.beimin.eveapi.model.shared.NamedList;
import com.beimin.eveapi.response.shared.AbstractContactListResponse;

public class ContactListResponse extends AbstractContactListResponse {
    public NamedList<Contact> getContactList() {
        return contactLists.get("contactList");
    }

    public NamedList<ContactLabel> getContactLabelList() {
        return labelLists.get("contactLabels");
    }
}
