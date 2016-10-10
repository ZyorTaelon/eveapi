package com.beimin.eveapi.character.contacts;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.pilot.ContactNotificationsParser;
import com.beimin.eveapi.response.pilot.ContactNotificationsResponse;
import org.junit.Ignore;

public class ContactNotificationsParserOnlineTest extends AbstractOnlineTest {

    @Test @Ignore("No data returned by the API")
    public void getResponse() throws Exception {
        final ContactNotificationsParser parser = new ContactNotificationsParser();
        final ContactNotificationsResponse response = parser.getResponse(getPilot());
        testResponse(response);
    }

}
