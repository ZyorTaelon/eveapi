package com.beimin.eveapi.character.contacts;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.character.ContactNotificationsParser;
import com.beimin.eveapi.response.character.ContactNotificationsResponse;

public class ContactNotificationsParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        setAlias(ContactNotificationsResponse.class, "contactNotifications", "items");
        final ContactNotificationsParser parser = new ContactNotificationsParser();
        prepareParser(parser);

        final ContactNotificationsResponse response = parser.getResponse(getCharacter());

        testResponse(response);
    }

}
