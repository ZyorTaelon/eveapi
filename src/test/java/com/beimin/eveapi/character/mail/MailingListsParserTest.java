package com.beimin.eveapi.character.mail;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Test;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.model.pilot.MailingList;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.pilot.MailingListsParser;
import com.beimin.eveapi.response.pilot.MailingListsResponse;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class MailingListsParserTest extends FullAuthParserTest {
	public MailingListsParserTest() {
		super(ApiPath.CHARACTER, ApiPage.MAILING_LISTS);
	}

	@Test
	public void getResponse() throws ApiException {
		MailingListsParser parser = new MailingListsParser();
		MailingListsResponse response = parser.getResponse(auth);
		assertNotNull(response);
		Set<MailingList> mailinglists = response.getAll();
		assertNotNull(mailinglists);
		assertEquals(3, mailinglists.size());
		boolean found = false;
		for (MailingList mailinglist : mailinglists) {
			if (mailinglist.getListID() == 128250439L) {
				found = true;
				assertEquals("EVETycoonMail", mailinglist.getDisplayName());
				break;
			}
		}
		assertTrue("Test mail wasn't found.", found);
	}
}