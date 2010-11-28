package com.beimin.eveapi.corporation.contacts;

import com.beimin.eveapi.shared.contacts.AbstractContactListParser;

public class ContactListParser extends AbstractContactListParser<ContactListResponse> {

	protected ContactListParser() {
		super(ContactListResponse.class, Path.CORPORATION);
	}

	public static ContactListParser getInstance() {
		return new ContactListParser();
	}
}