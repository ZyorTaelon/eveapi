package com.beimin.eveapi.corporation.contacts;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.beimin.eveapi.shared.contacts.ApiContact;
import com.beimin.eveapi.shared.contacts.ContactList;

public class ContactListParserTest {

	@Test
	public void contactListParser() throws IOException, SAXException, ParseException {
		ContactListParser parser = ContactListParser.getInstance();
		InputStream input = ContactListParserTest.class.getResourceAsStream("/corporation/ContactList.xml");
		ContactListResponse response = parser.getResponse(input);
		assertNotNull(response);

		ContactList corporateContactList = response.getCorporateContactList();
		assertEquals("corporateContactList", corporateContactList.getName());
		assertEquals(19, corporateContactList.size());
		ApiContact apiContact = corporateContactList.iterator().next();
		assertEquals(126118228, apiContact.getContactID());
		assertEquals("Alpha Guardians", apiContact.getContactName());
		assertEquals(10.0, apiContact.getStanding(), 1E-15);
		assertFalse(apiContact.isInWatchlist());

		ContactList allianceContactList = response.getAllianceContactList();
		assertEquals("allianceContactList", allianceContactList.getName());
		assertEquals(210, allianceContactList.size());
		apiContact = allianceContactList.iterator().next();
		assertEquals(121766272, apiContact.getContactID());
		assertEquals("X-COM", apiContact.getContactName());
		assertEquals(5.0, apiContact.getStanding(), 1E-15);
		assertFalse(apiContact.isInWatchlist());
	}
}