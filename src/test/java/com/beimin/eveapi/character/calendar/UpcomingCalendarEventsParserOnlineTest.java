package com.beimin.eveapi.character.calendar;


import com.beimin.eveapi.AbstractOnlineTest;

import org.junit.Test;

import com.beimin.eveapi.parser.pilot.UpcomingCalendarEventsParser;
import com.beimin.eveapi.response.pilot.UpcomingCalendarEventsResponse;

public class UpcomingCalendarEventsParserOnlineTest extends AbstractOnlineTest {

	@Test
	public void getResponse() throws Exception {
		UpcomingCalendarEventsParser parser = new UpcomingCalendarEventsParser();
		UpcomingCalendarEventsResponse response = parser.getResponse(getPilot());
		testResponse(response);
	}

}