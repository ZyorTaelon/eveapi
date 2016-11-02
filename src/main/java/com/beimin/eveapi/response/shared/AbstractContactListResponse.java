package com.beimin.eveapi.response.shared;

import java.util.HashSet;
import java.util.Set;

import com.beimin.eveapi.model.shared.Contact;
import com.beimin.eveapi.model.shared.ContactLabel;
import com.beimin.eveapi.response.ApiResponse;

public abstract class AbstractContactListResponse extends ApiResponse {
    private final Set<Contact> contactList = new HashSet<>();
    private final Set<ContactLabel> contactLabels = new HashSet<>();
    private final Set<Contact> corporateContactList = new HashSet<>();
    private final Set<ContactLabel> corporateContactLabels = new HashSet<>();
    private final Set<Contact> allianceContactList = new HashSet<>();
    private final Set<ContactLabel> allianceContactLabels = new HashSet<>();

    public void addContact(Contact contact) {
        contactList.add(contact);
    }

    protected Set<Contact> getContactList() {
        return contactList;
    }

    public void addContactLabel(ContactLabel contactLabel) {
        contactLabels.add(contactLabel);
    }

    protected Set<ContactLabel> getContactLabels() {
        return contactLabels;
    }

    public void addCorporateContact(Contact contact) {
        corporateContactList.add(contact);
    }

    protected Set<Contact> getCorporateContactList() {
        return corporateContactList;
    }

    public void addCorporateContactLabel(ContactLabel contactLabel) {
        corporateContactLabels.add(contactLabel);
    }

    protected Set<ContactLabel> getCorporateContactLabels() {
        return corporateContactLabels;
    }

    public void addAllianceContact(Contact contact) {
        allianceContactList.add(contact);
    }

    protected Set<Contact> getAllianceContactList() {
        return allianceContactList;
    }

    public void addAllianceContactLabel(ContactLabel contactLabel) {
        allianceContactLabels.add(contactLabel);
    }

    protected Set<ContactLabel> getAllianceContactLabels() {
        return allianceContactLabels;
    }
}
