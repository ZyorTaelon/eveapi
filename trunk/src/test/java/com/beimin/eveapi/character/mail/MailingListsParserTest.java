package com.beimin.eveapi.character.mail;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Set;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.beimin.eveapi.FullApiParserTest;
import com.beimin.eveapi.character.mail.lists.ApiMailingList;
import com.beimin.eveapi.character.mail.lists.MailingListsParser;
import com.beimin.eveapi.character.mail.lists.MailingListsResponse;

public class MailingListsParserTest extends FullApiParserTest {
	public MailingListsParserTest() {
		super("/char/MailingLists.xml.aspx", "/character/MailingLists.xml");
	}

	@Test
	public void mailMailingListsParser() throws IOException, SAXException {
		MailingListsParser parser = MailingListsParser.getInstance();
		MailingListsResponse response = parser.getMailingListsResponse(auth);
		assertNotNull(response);
		Set<ApiMailingList> mailinglists = response.getMailingLists();
		assertNotNull(mailinglists);
		assertEquals(3, mailinglists.size());
		boolean found = false;
		for (ApiMailingList mailinglist : mailinglists) {
			if (mailinglist.getListID() == 128250439L) {
				found = true;
				assertEquals("EVETycoonMail", mailinglist.getDisplayName());
				break;
			}
		}
		assertTrue("Test mail wasn't found.", found);
	}
}