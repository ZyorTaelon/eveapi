package com.beimin.eveapi.character.mail;

import java.util.Set;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.TestControl;
import com.beimin.eveapi.model.pilot.MailMessage;
import com.beimin.eveapi.parser.pilot.MailBodiesParser;
import com.beimin.eveapi.parser.pilot.MailMessagesParser;
import com.beimin.eveapi.response.pilot.MailBodiesResponse;
import com.beimin.eveapi.response.pilot.MailMessagesResponse;
import static org.junit.Assume.assumeTrue;

public class MailBodiesParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        assumeTrue("Other error", TestControl.runOther());
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
