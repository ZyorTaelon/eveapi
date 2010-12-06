package com.beimin.eveapi.shared.contacts;

import java.util.HashMap;
import java.util.Map;

import com.beimin.eveapi.core.ApiResponse;

public class AbstractContactListResponse extends ApiResponse {
	private static final long serialVersionUID = 2L;
	protected Map<String, ContactList> contactLists = new HashMap<String, ContactList>();

	public void addContactList(ContactList contactList) {
		contactLists.put(contactList.getName(), contactList);
	}
}