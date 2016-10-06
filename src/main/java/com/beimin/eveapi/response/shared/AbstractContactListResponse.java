package com.beimin.eveapi.response.shared;

import java.util.HashMap;
import java.util.Map;

import com.beimin.eveapi.model.shared.ContactLabelList;
import com.beimin.eveapi.model.shared.ContactList;
import com.beimin.eveapi.response.ApiResponse;

public abstract class AbstractContactListResponse extends ApiResponse {
	protected Map<String, ContactList> contactLists = new HashMap<String, ContactList>();
	protected Map<String, ContactLabelList> labelLists = new HashMap<String, ContactLabelList>();

	public void add(ContactList list) {
		this.contactLists.put(list.getName(), list);
	}

	public void add(ContactLabelList list) {
		this.labelLists.put(list.getName(), list);
	}

	public ContactList get(String name) {
		return this.contactLists.get(name);
	}

	public ContactLabelList getLabels(String name) {
		return this.labelLists.get(name);
	}
}