package com.beimin.eveapi.character.mail;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.model.pilot.MailMessage;
import com.beimin.eveapi.parser.pilot.MailBodiesParser;

import org.junit.Test;

import com.beimin.eveapi.parser.pilot.MailMessagesParser;
import com.beimin.eveapi.response.pilot.MailBodiesResponse;
import com.beimin.eveapi.response.pilot.MailMessagesResponse;
import java.util.Set;

public class MailBodiesParserOnlineTest extends AbstractOnlineTest {

	@Test
	public void getResponse() throws Exception {
		MailMessagesParser mailMessagesParser = new MailMessagesParser();
		MailMessagesResponse mailMessagesResponse = mailMessagesParser.getResponse(getPilot());
		Set<MailMessage> mailMessages = mailMessagesResponse.getAll();
		test(mailMessages);
		MailBodiesParser parser = new MailBodiesParser();
		for (MailMessage mailMessage : mailMessages) {
			MailBodiesResponse response = parser.getResponse(getPilot(), mailMessage.getMessageID());
			testResponse(response);
		}
	}

}