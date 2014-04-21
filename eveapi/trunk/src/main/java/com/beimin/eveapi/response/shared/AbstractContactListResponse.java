package com.beimin.eveapi.response.shared;

import java.util.HashMap;
import java.util.Map;

import com.beimin.eveapi.model.shared.ContactList;
import com.beimin.eveapi.response.ApiResponse;

public abstract class AbstractContactListResponse extends ApiResponse {
	private static final long serialVersionUID = 2L;
	protected Map<String, ContactList> contactLists = new HashMap<String, ContactList>();

	public void add(ContactList list) {
		this.contactLists.put(list.getName(), list);
	}

	public ContactList get(String name) {
		return this.contactLists.get(name);
	}
}