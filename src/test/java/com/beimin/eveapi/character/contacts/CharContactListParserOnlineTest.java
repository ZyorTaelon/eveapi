package com.beimin.eveapi.character.contacts;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.pilot.ContactListParser;
import com.beimin.eveapi.response.pilot.ContactListResponse;

public class CharContactListParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        final ContactListParser parser = new ContactListParser();
        final ContactListResponse response = parser.getResponse(getPilot());
        testResponse(response);
    }

}