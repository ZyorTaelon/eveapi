package com.beimin.eveapi.character.mailmessages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Set;

import org.junit.Test;
import org.xml.sax.SAXException;

public class MailMessagesParserTest {

	@Test
	public void mailMessagesParser() throws IOException, SAXException {
		EveMailParser parser = EveMailParser.getInstance();
		InputStream input = MailMessagesParserTest.class.getResourceAsStream("/character/MailMessages.xml");
		EveMaiResponse response = parser.getResponse(input);
		assertNotNull(response);
		Set<ApiEveMai> mails = response.getApiMails();
		assertNotNull(mails);
		assertEquals(2, mails.size());
		boolean found = false;
		for (ApiEveMai mail : mails) {
			if(mail.getMessageID()==291362193L){
				found=true;
				assertEquals(267936250L, mail.getSenderID());
				Calendar calendar = Calendar.getInstance();
				calendar.set(Calendar.YEAR, 2010);
				calendar.set(Calendar.MONTH, 0);
				calendar.set(Calendar.DAY_OF_MONTH, 12);
				calendar.set(Calendar.HOUR_OF_DAY, 3);
				calendar.set(Calendar.MINUTE, 29);
				calendar.set(Calendar.SECOND, 0);
				calendar.set(Calendar.MILLISECOND, 0);
				assertEquals(calendar.getTime(), mail.getSentDate());
				assertEquals("FW: hulkageddon 2", mail.getTitle());
				assertEquals(1449814438L, mail.getToCorpOrAllianceID());
				assertNull(mail.getToCharacterIDs());
				assertNull(mail.getToListIDs());
				assertEquals(false, mail.isRead());
				break;
			}
		}
		assertTrue("Test mail wasn't found.", found);
	}
}