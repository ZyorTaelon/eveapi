package com.beimin.eveapi.character.contact.list;

import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.shared.contacts.AbstractContactListParser;

public class ContactListParser extends AbstractContactListParser<ContactListResponse> {
	protected ContactListParser() {
		super(ContactListResponse.class, ApiPath.CHARACTER);
	}

	public static ContactListParser getInstance() {
		return new ContactListParser();
	}
}