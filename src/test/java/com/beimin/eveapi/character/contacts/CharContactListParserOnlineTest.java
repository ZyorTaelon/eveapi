package com.beimin.eveapi.character.contacts;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.pilot.CharContactListParser;
import com.beimin.eveapi.response.pilot.ContactListResponse;
import org.junit.Ignore;

public class CharContactListParserOnlineTest extends AbstractOnlineTest {

    @Test @Ignore("No data returned by the API")
    public void getResponse() throws Exception {
        final CharContactListParser parser = new CharContactListParser();
        final ContactListResponse response = parser.getResponse(getPilot());
        testResponse(response);
    }

}
