package com.beimin.eveapi.character.calendar;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.pilot.UpcomingCalendarEventsParser;
import com.beimin.eveapi.response.pilot.UpcomingCalendarEventsResponse;
import org.junit.Ignore;

public class UpcomingCalendarEventsParserOnlineTest extends AbstractOnlineTest {

    @Test @Ignore("No data returned by the API")
    public void getResponse() throws Exception {
        final UpcomingCalendarEventsParser parser = new UpcomingCalendarEventsParser();
        final UpcomingCalendarEventsResponse response = parser.getResponse(getPilot());
        testResponse(response);
    }

}
