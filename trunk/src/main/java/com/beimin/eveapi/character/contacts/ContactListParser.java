package com.beimin.eveapi.character.contacts;

import com.beimin.eveapi.shared.contacts.AbstractContactListParser;

public class ContactListParser extends AbstractContactListParser<ContactListResponse> {

	protected ContactListParser() {
		super(ContactListResponse.class, Path.CHARACTER);
	}

	public static ContactListParser getInstance() {
		return new ContactListParser();
	}
}