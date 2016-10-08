package com.beimin.eveapi.character.mail;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.pilot.MailingListsParser;
import com.beimin.eveapi.response.pilot.MailingListsResponse;

public class MailingListsParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        final MailingListsParser parser = new MailingListsParser();
        final MailingListsResponse response = parser.getResponse(getPilot());
        testResponse(response);
    }

}
