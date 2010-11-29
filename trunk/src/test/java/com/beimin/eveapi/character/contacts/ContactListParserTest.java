package com.beimin.eveapi.character.contacts;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.beimin.eveapi.shared.contacts.ApiContact;
import com.beimin.eveapi.shared.contacts.ContactList;

public class ContactListParserTest {

	@Test
	public void contactListParser() throws IOException, SAXException {
		ContactListParser parser = ContactListParser.getInstance();
		InputStream input = ContactListParserTest.class.getResourceAsStream("/character/ContactList.xml");
		ContactListResponse response = parser.getResponse(input);
		assertNotNull(response);

		ContactList contactList = response.getContactList();
		assertEquals("contactList", contactList.getName());
		assertEquals(106, contactList.size());
		ApiContact apiContact = contactList.iterator().next();
		assertEquals(3008667, apiContact.getContactID());
		assertEquals("Falian Khivad", apiContact.getContactName());
		assertEquals(5.0, apiContact.getStanding(), 1E-15);
		assertFalse(apiContact.isInWatchlist());

		apiContact = contactList.get(contactList.size() - 1);
		assertEquals(2065725204, apiContact.getContactID());
		assertEquals("De Boer", apiContact.getContactName());
		assertEquals(10.0, apiContact.getStanding(), 1E-15);
		assertTrue(apiContact.isInWatchlist());
	}
}