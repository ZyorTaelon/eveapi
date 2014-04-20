package com.beimin.eveapi.character.contacts;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.beimin.eveapi.character.contact.list.CharacterContactListParser;
import com.beimin.eveapi.character.contact.list.CharacterContactListResponse;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.shared.contacts.ContactList;
import com.beimin.eveapi.shared.contacts.EveContact;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class ContactListParserTest extends FullAuthParserTest {
	public ContactListParserTest() {
		super(ApiPath.CHARACTER, ApiPage.CONTACT_LIST);
	}

	@Test
	public void getResponse() throws ApiException {
		CharacterContactListParser parser = new CharacterContactListParser();
		CharacterContactListResponse response = parser.getResponse(auth);
		assertNotNull(response);

		ContactList contactList = response.getContactList();
		assertEquals("contactList", contactList.getName());
		assertEquals(106, contactList.size());
		EveContact apiContact = contactList.iterator().next();
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