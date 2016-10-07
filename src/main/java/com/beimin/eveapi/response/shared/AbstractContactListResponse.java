package com.beimin.eveapi.response.shared;

import java.util.HashMap;
import java.util.Map;

import com.beimin.eveapi.model.shared.ContactLabelList;
import com.beimin.eveapi.model.shared.ContactList;
import com.beimin.eveapi.response.ApiResponse;

public abstract class AbstractContactListResponse extends ApiResponse {
    protected Map<String, ContactList> contactLists = new HashMap<String, ContactList>();
    protected Map<String, ContactLabelList> labelLists = new HashMap<String, ContactLabelList>();

    public void add(final ContactList list) {
        contactLists.put(list.getName(), list);
    }

    public void add(final ContactLabelList list) {
        labelLists.put(list.getName(), list);
    }

    public ContactList get(final String name) {
        return contactLists.get(name);
    }

    public ContactLabelList getLabels(final String name) {
        return labelLists.get(name);
    }
}