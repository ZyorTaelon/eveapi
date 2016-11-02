package com.beimin.eveapi.character.mail;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.character.MailingListsParser;
import com.beimin.eveapi.response.character.MailingListsResponse;

public class MailingListsParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        setAlias(MailingListsResponse.class, "mailingLists", "items");
        final MailingListsParser parser = new MailingListsParser();
        prepareParser(parser);

        final MailingListsResponse response = parser.getResponse(getCharacter());

        testResponse(response);
    }

}
