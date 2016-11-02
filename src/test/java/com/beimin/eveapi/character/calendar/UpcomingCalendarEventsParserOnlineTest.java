package com.beimin.eveapi.character.calendar;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.model.character.UpcomingCalendarEvent;
import com.beimin.eveapi.parser.character.UpcomingCalendarEventsParser;
import com.beimin.eveapi.response.character.UpcomingCalendarEventsResponse;

public class UpcomingCalendarEventsParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        setAlias(UpcomingCalendarEvent.class, "importance", "important");
        setAlias(UpcomingCalendarEventsResponse.class, "upcomingevents", "items");
        allowEmpty("getOwnerTypeID");
        final UpcomingCalendarEventsParser parser = new UpcomingCalendarEventsParser();
        prepareParser(parser);

        final UpcomingCalendarEventsResponse response = parser.getResponse(getCharacter());

        testResponse(response);
    }

}
