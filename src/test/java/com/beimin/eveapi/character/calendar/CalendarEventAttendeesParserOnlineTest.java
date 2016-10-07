package com.beimin.eveapi.character.calendar;


import com.beimin.eveapi.AbstractOnlineTest;
import java.util.Set;

import org.junit.Test;

import com.beimin.eveapi.model.pilot.UpcomingCalendarEvent;
import com.beimin.eveapi.parser.pilot.CalendarEventAttendeesParser;
import com.beimin.eveapi.parser.pilot.UpcomingCalendarEventsParser;
import com.beimin.eveapi.response.pilot.CalendarEventAttendeesResponse;
import com.beimin.eveapi.response.pilot.UpcomingCalendarEventsResponse;

public class CalendarEventAttendeesParserOnlineTest extends AbstractOnlineTest {

	@Test
	public void getResponse() throws Exception {
		UpcomingCalendarEventsParser upcomingCalendarEventsParser = new UpcomingCalendarEventsParser();
		UpcomingCalendarEventsResponse upcomingCalendarEventsResponse = upcomingCalendarEventsParser.getResponse(getPilot());
		testResponse(upcomingCalendarEventsResponse);
		Set<UpcomingCalendarEvent> upcomingCalendarEvents = upcomingCalendarEventsResponse.getAll();
		test(upcomingCalendarEvents);
		for (UpcomingCalendarEvent upcomingCalendarEvent : upcomingCalendarEvents) {
			CalendarEventAttendeesParser parser = new CalendarEventAttendeesParser();
			CalendarEventAttendeesResponse response = parser.getResponse(getPilot(), upcomingCalendarEvent.getEventID());
			testResponse(response);
		}
	}

}