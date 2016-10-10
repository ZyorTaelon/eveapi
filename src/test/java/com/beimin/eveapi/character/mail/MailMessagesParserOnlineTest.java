package com.beimin.eveapi.character.mail;

import org.junit.Ignore;
import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.pilot.MailMessagesParser;
import com.beimin.eveapi.response.pilot.MailMessagesResponse;

public class MailMessagesParserOnlineTest extends AbstractOnlineTest {

    @Test @Ignore("Some data missing")
    public void getResponse() throws Exception {
        final MailMessagesParser parser = new MailMessagesParser();
        prepareParser(parser);

        final MailMessagesResponse response = parser.getResponse(getCharacter());

        testResponse(response);
    }

}
