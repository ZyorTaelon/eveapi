package com.beimin.eveapi.character.contacts;

import org.junit.Ignore;
import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.pilot.CharContactListParser;
import com.beimin.eveapi.response.pilot.ContactListResponse;

public class CharContactListParserOnlineTest extends AbstractOnlineTest {

    @Test @Ignore("No data returned by the API")
    public void getResponse() throws Exception {
        final CharContactListParser parser = new CharContactListParser();
        prepareParser(parser);

        final ContactListResponse response = parser.getResponse(getCharacter());

        testResponse(response);
    }

}
