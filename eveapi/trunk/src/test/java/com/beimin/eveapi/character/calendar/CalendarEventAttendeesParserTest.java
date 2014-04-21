package com.beimin.eveapi.character.calendar;

import static org.junit.Assert.assertEquals;

import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.model.pilot.CalendarEventAttendee;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.pilot.CalendarEventAttendeesParser;
import com.beimin.eveapi.response.pilot.CalendarEventAttendeesResponse;
import com.beimin.eveapi.response.pilot.CalendarEventResponse;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class CalendarEventAttendeesParserTest extends FullAuthParserTest {
	public CalendarEventAttendeesParserTest() {
		super(ApiPath.CHARACTER, ApiPage.CALENDAR_EVENT_ATTENDEES);
	}

	@Test
	public void getResponse() throws ApiException {
		CalendarEventAttendeesParser parser = new CalendarEventAttendeesParser();
		CalendarEventAttendeesResponse response = parser.getResponse(auth, 133918L);
		Set<CalendarEventAttendee> attendees = response.getAll();
		assertEquals(1, attendees.size());
		CalendarEventAttendee event = attendees.iterator().next();
		assertEquals(133918L, event.getEventID());
		assertEquals(1380128241L, event.getCharacterID());
		assertEquals("Zy'or Tealon", event.getCharacterName());
		assertEquals(CalendarEventResponse.ACCEPTED, event.getResponse());
	}

	@Override
	public void extraAsserts(Map<String, String> req) {
		super.extraAsserts(req);
		assertEquals("133918", req.get("eventIDs"));
	}
}