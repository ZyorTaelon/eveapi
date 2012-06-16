package com.beimin.eveapi.character.mailinglists;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

import org.junit.Test;
import org.xml.sax.SAXException;

public class MailingListsParserTest {

	@Test
	public void mailMailingListsParser() throws IOException, SAXException {
		MailingListsParser parser = MailingListsParser.getInstance();
		InputStream input = MailingListsParserTest.class.getResourceAsStream("/character/MailingLists.xml");
		MailingListsResponse response = parser.getResponse(input);
		assertNotNull(response);
		Set<ApiMailingList> mailinglists = response.getMailingLists();
		assertNotNull(mailinglists);
		assertEquals(3, mailinglists.size());
		boolean found = false;
		for (ApiMailingList mailinglist : mailinglists) {
			if(mailinglist.getListID()==128250439L){
				found=true;
				assertEquals("EVETycoonMail", mailinglist.getDisplayName());
				break;
			}
		}
		assertTrue("Test mail wasn't found.", found);
	}
}