package com.beimin.eveapi.character.calendar;

import static com.beimin.eveapi.utils.Assert.assertDate;
import static org.junit.Assert.assertEquals;

import java.util.Set;

import org.junit.Test;

import com.beimin.eveapi.character.calendar.upcomingevents.ApiUpcomingCalendarEvent;
import com.beimin.eveapi.character.calendar.upcomingevents.UpcomingCalendarEventsParser;
import com.beimin.eveapi.character.calendar.upcomingevents.UpcomingCalendarEventsResponse;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.shared.calendar.CalendarEventResponse;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class UpcomingCalendarEventsParserTest extends FullAuthParserTest {
	public UpcomingCalendarEventsParserTest() {
		super(ApiPath.CHARACTER, ApiPage.UPCOMING_CALENDAR_EVENTS);
	}

	@Test
	public void getResponse() throws ApiException {
		UpcomingCalendarEventsParser parser = UpcomingCalendarEventsParser.getInstance();
		UpcomingCalendarEventsResponse response = parser.getResponse(auth);
		Set<ApiUpcomingCalendarEvent> events = response.getAll();
		assertEquals(1, events.size());
		ApiUpcomingCalendarEvent event = events.iterator().next();
		assertEquals(90864L, event.getEventID());
		assertEquals(786344537L, event.getOwnerID());
		assertEquals("Some Alliance", event.getOwnerName());
		assertDate(2010, 11, 28, 17, 00, 00, event.getEventDate());
		assertEquals("Some Mining OP @ 17:00", event.getEventTitle());
		assertEquals(120, event.getDuration());
		assertEquals(true, event.isImportant());
		assertEquals(CalendarEventResponse.UNDECIDED, event.getResponse());
		String expectedEventText = "Alliance Mining OP Part II<br><br>This will be in home system the sunday after the patch..<br>We would really like to see as many mining barges out there as possible. PVPers are also needed for security.. See you there!!!";
		assertEquals(expectedEventText, event.getEventText());
	}
}