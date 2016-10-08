package com.beimin.eveapi.response.shared;

import java.util.HashMap;
import java.util.Map;

import com.beimin.eveapi.model.shared.Contact;
import com.beimin.eveapi.model.shared.ContactLabel;
import com.beimin.eveapi.model.shared.NamedList;
import com.beimin.eveapi.response.ApiResponse;

public abstract class AbstractContactListResponse extends ApiResponse {
    protected Map<String, NamedList<Contact>> contactLists = new HashMap<>();
    protected Map<String, NamedList<ContactLabel>> labelLists = new HashMap<>();

    public void add(final NamedList<Contact> list) {
        contactLists.put(list.getName(), list);
    }

    public void addLabels(final NamedList<ContactLabel> list) {
        labelLists.put(list.getName(), list);
    }

    public NamedList<Contact> get(final String name) {
        return contactLists.get(name);
    }

    public NamedList<ContactLabel> getLabels(final String name) {
        return labelLists.get(name);
    }
}
