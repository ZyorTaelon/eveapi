package com.beimin.eveapi.response.shared;

import java.util.ArrayList;
import java.util.List;

import com.beimin.eveapi.model.shared.Contact;
import com.beimin.eveapi.model.shared.ContactLabel;
import com.beimin.eveapi.response.ApiResponse;

public abstract class AbstractContactListResponse extends ApiResponse {
    private final List<Contact> contactList = new ArrayList<>();
    private final List<ContactLabel> contactLabels = new ArrayList<>();
    private final List<Contact> corporateContactList = new ArrayList<>();
    private final List<ContactLabel> corporateContactLabels = new ArrayList<>();
    private final List<Contact> allianceContactList = new ArrayList<>();
    private final List<ContactLabel> allianceContactLabels = new ArrayList<>();

    public void addContact(Contact contact) {
        contactList.add(contact);
    }

    protected List<Contact> getContactList() {
        return contactList;
    }

    public void addContactLabel(ContactLabel contactLabel) {
        contactLabels.add(contactLabel);
    }

    protected List<ContactLabel> getContactLabels() {
        return contactLabels;
    }

    public void addCorporateContact(Contact contact) {
        corporateContactList.add(contact);
    }

    protected List<Contact> getCorporateContactList() {
        return corporateContactList;
    }

    public void addCorporateContactLabel(ContactLabel contactLabel) {
        corporateContactLabels.add(contactLabel);
    }

    protected List<ContactLabel> getCorporateContactLabels() {
        return corporateContactLabels;
    }

    public void addAllianceContact(Contact contact) {
        allianceContactList.add(contact);
    }

    protected List<Contact> getAllianceContactList() {
        return allianceContactList;
    }

    public void addAllianceContactLabel(ContactLabel contactLabel) {
        allianceContactLabels.add(contactLabel);
    }

    protected List<ContactLabel> getAllianceContactLabels() {
        return allianceContactLabels;
    }
}
