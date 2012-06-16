package com.beimin.eveapi.corporation.contacts;

import com.beimin.eveapi.shared.contacts.AbstractContactListResponse;
import com.beimin.eveapi.shared.contacts.ContactList;

public class ContactListResponse extends AbstractContactListResponse {
	private static final long serialVersionUID = 1L;

	public ContactList getCorporateContactList() {
		return contactLists.get("corporateContactList");
	}

	public ContactList getAllianceContactList() {
		return contactLists.get("allianceContactList");
	}
}