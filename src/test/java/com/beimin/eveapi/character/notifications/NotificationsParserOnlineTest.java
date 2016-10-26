package com.beimin.eveapi.character.notifications;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.pilot.NotificationsParser;
import com.beimin.eveapi.response.pilot.NotificationsResponse;

public class NotificationsParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        setAlias(NotificationsResponse.class, "notifications", "items");
        final NotificationsParser parser = new NotificationsParser();
        prepareParser(parser);

        final NotificationsResponse response = parser.getResponse(getCharacter());

        testResponse(response);
    }

}
