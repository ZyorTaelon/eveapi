package com.beimin.eveapi.character.calendar;

import java.util.List;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.model.character.UpcomingCalendarEvent;
import com.beimin.eveapi.parser.character.CalendarEventAttendeesParser;
import com.beimin.eveapi.parser.character.UpcomingCalendarEventsParser;
import com.beimin.eveapi.response.character.CalendarEventAttendeesResponse;
import com.beimin.eveapi.response.character.UpcomingCalendarEventsResponse;

public class CalendarEventAttendeesParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        setAlias(CalendarEventAttendeesResponse.class, "eventAttendees", "items");
        final UpcomingCalendarEventsParser upcomingCalendarEventsParser = new UpcomingCalendarEventsParser();
        final UpcomingCalendarEventsResponse upcomingCalendarEventsResponse = upcomingCalendarEventsParser.getResponse(getCharacter());
        final List<UpcomingCalendarEvent> upcomingCalendarEvents = upcomingCalendarEventsResponse.getAll();
        test(upcomingCalendarEvents);
        for (final UpcomingCalendarEvent upcomingCalendarEvent : upcomingCalendarEvents) {
            final CalendarEventAttendeesParser parser = new CalendarEventAttendeesParser();
            prepareParser(parser);

            final CalendarEventAttendeesResponse response = parser.getResponse(getCharacter(), upcomingCalendarEvent.getEventID());

            testResponse(response);
        }
    }

}
