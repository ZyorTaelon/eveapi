package com.beimin.eveapi.character.contacts;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.model.shared.Contact;
import com.beimin.eveapi.model.shared.ContactList;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.pilot.ContactListParser;
import com.beimin.eveapi.response.pilot.ContactListResponse;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class ContactListParserTest extends FullAuthParserTest {
	public ContactListParserTest() {
		super(ApiPath.CHARACTER, ApiPage.CONTACT_LIST);
	}

	@Test
	public void getResponse() throws ApiException {
		ContactListParser parser = new ContactListParser();
		ContactListResponse response = parser.getResponse(auth);
		assertNotNull(response);

		ContactList contactList = response.getContactList();
		assertEquals("contactList", contactList.getName());
		assertEquals(106, contactList.size());
		Contact apiContact = contactList.iterator().next();
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