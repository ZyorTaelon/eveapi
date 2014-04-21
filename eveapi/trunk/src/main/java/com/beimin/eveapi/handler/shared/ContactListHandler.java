package com.beimin.eveapi.handler.shared;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.handler.AbstractContentHandler;
import com.beimin.eveapi.model.shared.Contact;
import com.beimin.eveapi.model.shared.ContactList;
import com.beimin.eveapi.response.shared.AbstractContactListResponse;

public class ContactListHandler<CLR extends AbstractContactListResponse> extends AbstractContentHandler {
	private final Class<CLR> clazz;
	private CLR response;
	private ContactList contactList;

	public ContactListHandler(Class<CLR> clazz) {
		this.clazz = clazz;
	}

	@Override
	public void startDocument() throws SAXException {
		try {
			response = clazz.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attrs) throws SAXException {
		if (qName.equals("rowset")) {
			contactList = new ContactList();
			contactList.setName(getString(attrs, "name"));
		}
		if (qName.equals("row")) {
			Contact contact = new Contact();
			contact.setContactID(getInt(attrs, "contactID"));
			contact.setContactName(getString(attrs, "contactName"));
			contact.setInWatchlist(getBoolean(attrs, "inWatchlist"));
			contact.setStanding(getDouble(attrs, "standing"));
			contactList.add(contact);
		}
		super.startElement(uri, localName, qName, attrs);
		accumulator.setLength(0);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equals("rowset")) {
			response.add(contactList);
			contactList = null;
		}
		super.endElement(uri, localName, qName);
	}

	@Override
	public CLR getResponse() {
		return response;
	}
}