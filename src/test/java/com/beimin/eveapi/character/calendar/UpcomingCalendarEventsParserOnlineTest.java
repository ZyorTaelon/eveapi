package com.beimin.eveapi.character.calendar;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.pilot.UpcomingCalendarEventsParser;
import com.beimin.eveapi.response.pilot.UpcomingCalendarEventsResponse;

public class UpcomingCalendarEventsParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        final UpcomingCalendarEventsParser parser = new UpcomingCalendarEventsParser();
        final UpcomingCalendarEventsResponse response = parser.getResponse(getPilot());
        testResponse(response);
    }

}