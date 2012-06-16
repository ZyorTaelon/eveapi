package com.beimin.eveapi.shared.contacts;

import java.util.HashMap;
import java.util.Map;

import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiResponse;

public abstract class AbstractContactListResponse extends ApiResponse {
	private static final long serialVersionUID = 2L;
	protected Map<String, ContactList> contactLists = new HashMap<String, ContactList>();

	public abstract void add(ContactList contactList) throws ApiException;
}