package com.beimin.eveapi.character.contact.list;

import com.beimin.eveapi.shared.contacts.AbstractContactListResponse;
import com.beimin.eveapi.shared.contacts.ContactList;

public class ContactListResponse extends AbstractContactListResponse {
	private static final long serialVersionUID = 1L;
	private ContactList contactList;

	public ContactList getContactList() {
		return contactList;
	}

	@Override
	public void add(ContactList list) {
		this.contactList = list;
	}
}