package com.beimin.eveapi.character.mail;

import static com.beimin.eveapi.utils.Assert.assertDate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.beimin.eveapi.character.mail.messages.ApiMailMessage;
import com.beimin.eveapi.character.mail.messages.MailMessagesResponse;
import com.beimin.eveapi.character.mail.messages.MailMessagesParser;

public class MailMessagesParserTest {

	@Test
	public void mailMessagesParser() throws IOException, SAXException {
		MailMessagesParser parser = MailMessagesParser.getInstance();
		InputStream input = MailMessagesParserTest.class.getResourceAsStream("/character/MailMessages.xml");
		MailMessagesResponse response = parser.getResponse(input);
		assertNotNull(response);
		Set<ApiMailMessage> mails = response.getApiMails();
		assertNotNull(mails);
		assertEquals(2, mails.size());
		boolean found = false;
		for (ApiMailMessage mail : mails) {
			if (mail.getMessageID() == 291362193L) {
				found = true;
				assertEquals(267936250L, mail.getSenderID());
				assertDate(2010, 1, 12, 3, 29, 0, mail.getSentDate());
				assertEquals("FW: hulkageddon 2", mail.getTitle());
				assertEquals(1449814438L, mail.getToCorpOrAllianceID().longValue());
				assertNull(mail.getToCharacterIDs());
				assertNull(mail.getToListIDs());
				assertEquals(false, mail.isRead());
				break;
			}
		}
		assertTrue("Test mail wasn't found.", found);
	}
}