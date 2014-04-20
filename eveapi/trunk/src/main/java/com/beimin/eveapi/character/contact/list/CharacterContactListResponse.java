package com.beimin.eveapi.character.contact.list;

import com.beimin.eveapi.shared.contacts.AbstractContactListResponse;
import com.beimin.eveapi.shared.contacts.ContactList;

public class CharacterContactListResponse extends AbstractContactListResponse {
	private static final long serialVersionUID = 1L;

	public ContactList getContactList() {
		return contactLists.get("contactList");
	}
}