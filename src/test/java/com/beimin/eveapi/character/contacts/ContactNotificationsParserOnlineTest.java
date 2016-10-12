package com.beimin.eveapi.character.contacts;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.TestControl;
import com.beimin.eveapi.parser.pilot.ContactNotificationsParser;
import com.beimin.eveapi.response.pilot.ContactNotificationsResponse;
import static org.junit.Assume.assumeTrue;

public class ContactNotificationsParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        assumeTrue("No data returned by the API", TestControl.runNoData());
        final ContactNotificationsParser parser = new ContactNotificationsParser();
        prepareParser(parser);

        final ContactNotificationsResponse response = parser.getResponse(getCharacter());

        testResponse(response);
    }

}
