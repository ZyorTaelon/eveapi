package com.beimin.eveapi.corporation.contact.list;

import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.shared.contacts.AbstractContactListResponse;
import com.beimin.eveapi.shared.contacts.ContactList;

public class ContactListResponse extends AbstractContactListResponse {
	private static final long serialVersionUID = 1L;
	private ContactList corporateContactList;
	private ContactList allianceContactList;

	public ContactList getCorporateContactList() {
		return corporateContactList;
	}

	public ContactList getAllianceContactList() {
		return allianceContactList;
	}

	@Override
	public void add(ContactList contactList) throws ApiException {
		String name = contactList.getName();
		if ("corporateContactList".equals(name))
			this.corporateContactList = contactList;
		else if ("allianceContactList".equals(name))
			this.allianceContactList = contactList;
		else
			throw new ApiException("unexpected contact list type");
	}
}