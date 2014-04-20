package com.beimin.eveapi.corporation.contact.list;

import com.beimin.eveapi.shared.contacts.AbstractContactListResponse;
import com.beimin.eveapi.shared.contacts.ContactList;

public class CorporationContactListResponse extends AbstractContactListResponse {
	private static final long serialVersionUID = 1L;

	public ContactList getCorporateContactList() {
		return contactLists.get("corporateContactList");
	}

	public ContactList getAllianceContactList() {
		return contactLists.get("allianceContactList");
	}

}