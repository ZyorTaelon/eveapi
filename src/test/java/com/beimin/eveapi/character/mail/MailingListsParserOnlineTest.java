package com.beimin.eveapi.character.mail;

import org.junit.Ignore;
import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.pilot.MailingListsParser;
import com.beimin.eveapi.response.pilot.MailingListsResponse;

public class MailingListsParserOnlineTest extends AbstractOnlineTest {

    @Test @Ignore("No data returned by the API")
    public void getResponse() throws Exception {
        final MailingListsParser parser = new MailingListsParser();
        prepareParser(parser);

        final MailingListsResponse response = parser.getResponse(getCharacter());

        testResponse(response);
    }

}
