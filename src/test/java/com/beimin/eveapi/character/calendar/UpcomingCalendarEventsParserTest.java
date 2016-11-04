package com.beimin.eveapi.character.calendar;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Calendar;
import java.util.Set;

import org.junit.Test;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.model.character.CalendarEventStatus;
import com.beimin.eveapi.model.character.UpcomingCalendarEvent;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.character.UpcomingCalendarEventsParser;
import com.beimin.eveapi.response.character.UpcomingCalendarEventsResponse;
import com.beimin.eveapi.utils.FullAuthParserTest;
import com.beimin.eveapi.utils.GMTConverter;

public class UpcomingCalendarEventsParserTest extends FullAuthParserTest {
    public UpcomingCalendarEventsParserTest() {
        super(ApiPath.CHARACTER, ApiPage.UPCOMING_CALENDAR_EVENTS);
    }

    @Test
    public void getResponse() throws ApiException {
        final UpcomingCalendarEventsParser parser = new UpcomingCalendarEventsParser();
        final UpcomingCalendarEventsResponse response = parser.getResponse(auth);
        final Set<UpcomingCalendarEvent> events = response.getAll();
        assertThat(events.size(), equalTo(1));
        final UpcomingCalendarEvent event = events.iterator().next();
        assertThat(event.getEventID(), equalTo(90864L));
        assertThat(event.getOwnerID(), equalTo(786344537L));
        assertThat(event.getOwnerName(), equalTo("Some Alliance"));
        Calendar calendar = Calendar.getInstance(GMTConverter.DEFAULT_TIMEZONE);
        calendar.set(2010, 10, 28, 17, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        assertThat(event.getEventDate(), equalTo(calendar.getTime()));
        assertThat(event.getEventTitle(), equalTo("Some Mining OP @ 17:00"));
        assertThat(event.getDuration(), equalTo(120));
        assertThat(event.isImportant(), equalTo(true));
        assertThat(event.getResponse(), equalTo(CalendarEventStatus.UNDECIDED));
        assertThat(16159, equalTo(event.getOwnerTypeID()));
        final String expectedEventText = "Alliance Mining OP Part II<br><br>This will be in home system the sunday after the patch..<br>We would really like to see as many mining barges out there as possible. PVPers are also needed for security.. See you there!!!";
        assertThat(event.getEventText(), equalTo(expectedEventText));
    }
}
