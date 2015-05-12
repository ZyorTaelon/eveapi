package com.beimin.eveapi.response.pilot;

import com.beimin.eveapi.model.shared.ContactList;
import com.beimin.eveapi.response.shared.AbstractContactListResponse;

public class ContactListResponse extends AbstractContactListResponse {
	private static final long serialVersionUID = 1L;

	public ContactList getContactList() {
		return contactLists.get("contactList");
	}
}