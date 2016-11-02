package com.beimin.eveapi.character.mail;

import java.util.Set;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.model.character.MailMessage;
import com.beimin.eveapi.parser.character.MailBodiesParser;
import com.beimin.eveapi.parser.character.MailMessagesParser;
import com.beimin.eveapi.response.character.MailBodiesResponse;
import com.beimin.eveapi.response.character.MailMessagesResponse;

public class MailBodiesParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        final MailMessagesParser mailMessagesParser = new MailMessagesParser();
        final MailMessagesResponse mailMessagesResponse = mailMessagesParser.getResponse(getCharacter());
        final Set<MailMessage> mailMessages = mailMessagesResponse.getAll();
        test(mailMessages);
        final MailBodiesParser parser = new MailBodiesParser();
        prepareParser(parser);
        for (final MailMessage mailMessage : mailMessages) {

            final MailBodiesResponse response = parser.getResponse(getCharacter(), mailMessage.getMessageID());

            testResponse(response);
        }
    }

}
