package com.beimin.eveapi.character.mail;

import static com.beimin.eveapi.utils.Assert.assertDate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Test;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.model.pilot.MailMessage;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.pilot.MailMessagesParser;
import com.beimin.eveapi.response.pilot.MailMessagesResponse;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class MailMessagesParserTest extends FullAuthParserTest {
	public MailMessagesParserTest() {
		super(ApiPath.CHARACTER, ApiPage.MAIL_MESSAGES);
	}

	@Test
	public void getResponse() throws ApiException {
		MailMessagesParser parser = new MailMessagesParser();
		MailMessagesResponse response = parser.getResponse(auth);
		assertNotNull(response);
		Set<MailMessage> mails = response.getAll();
		assertNotNull(mails);
		assertEquals(2, mails.size());
		boolean found1 = false;
		boolean found2 = false;
		for (MailMessage mail : mails) {
			if (mail.getMessageID() == 291362193L) {
				found1 = true;
				assertEquals(267936250L, mail.getSenderID());
				assertDate(2010, 1, 12, 3, 29, 0, mail.getSentDate());
				assertEquals("FW: hulkageddon 2", mail.getTitle());
				assertEquals(1449814438L, mail.getToCorpOrAllianceID().longValue());
				assertNull(mail.getCharacterIDs());
				assertNull(mail.getListIDs());
				assertEquals(false, mail.isRead());
				continue;
			} else if (mail.getMessageID() == 291361244L) {
				found2 = true;
				assertEquals(267936250L, mail.getSenderID());
				assertDate(2010, 1, 12, 2, 42, 0, mail.getSentDate());
				assertEquals("FW: Congratulations for your achievement", mail.getTitle());
				assertNull(mail.getToCorpOrAllianceID());
				Set<Long> toCharacterIDs = mail.getCharacterIDs();
				assertTrue(toCharacterIDs.contains(new Long(1449814438)));
				assertTrue(toCharacterIDs.contains(new Long(1449814439)));
				Set<Long> toListIDs = mail.getListIDs();
				assertTrue(toListIDs.contains(new Long(1449814440)));
				assertTrue(toListIDs.contains(new Long(1449814444)));
				assertEquals(false, mail.isRead());
				continue;
			}
		}
		assertTrue("Test mail 1 wasn't found.", found1);
		assertTrue("Test mail 2 wasn't found.", found2);
	}
}