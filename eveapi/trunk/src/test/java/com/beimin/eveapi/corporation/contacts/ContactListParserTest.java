package com.beimin.eveapi.corporation.contacts;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.corporation.contact.list.CorporationContactListParser;
import com.beimin.eveapi.corporation.contact.list.CorporationContactListResponse;
import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.shared.contacts.ContactList;
import com.beimin.eveapi.shared.contacts.EveContact;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class ContactListParserTest extends FullAuthParserTest {
	public ContactListParserTest() {
		super(ApiPath.CORPORATION, ApiPage.CONTACT_LIST);
	}

	@Test
	public void getResponse() throws ApiException {
		CorporationContactListParser parser = new CorporationContactListParser();
		CorporationContactListResponse response = parser.getResponse(auth);
		assertNotNull(response);

		ContactList corporateContactList = response.getCorporateContactList();
		assertEquals("corporateContactList", corporateContactList.getName());
		assertEquals(19, corporateContactList.size());
		EveContact apiContact = corporateContactList.iterator().next();
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