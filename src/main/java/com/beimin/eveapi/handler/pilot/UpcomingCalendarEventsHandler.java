package com.beimin.eveapi.handler.pilot;

import org.xml.sax.Attributes;

import com.beimin.eveapi.handler.AbstractContentListHandler;
import com.beimin.eveapi.model.pilot.UpcomingCalendarEvent;
import com.beimin.eveapi.response.pilot.CalendarEventResponse;
import com.beimin.eveapi.response.pilot.UpcomingCalendarEventsResponse;

public class UpcomingCalendarEventsHandler extends AbstractContentListHandler<UpcomingCalendarEventsResponse, UpcomingCalendarEvent> {

	public UpcomingCalendarEventsHandler() {
		super(UpcomingCalendarEventsResponse.class);
	}

	@Override
	protected UpcomingCalendarEvent getItem(Attributes attrs) {
		UpcomingCalendarEvent calendarEvent = new UpcomingCalendarEvent();
		calendarEvent.setEventID(getLong(attrs, "eventID"));
		calendarEvent.setOwnerID(getLong(attrs, "ownerID"));
		calendarEvent.setOwnerName(getString(attrs, "ownerName"));
		calendarEvent.setEventDate(getDate(attrs, "eventDate"));
		calendarEvent.setEventTitle(getString(attrs, "eventTitle"));
		calendarEvent.setDuration(getInt(attrs, "duration"));
		calendarEvent.setImportance(getInt(attrs, "importance"));
		calendarEvent.setResponse(CalendarEventResponse.valueOf(getString(attrs, "response").toUpperCase()));
		calendarEvent.setEventText(getString(attrs, "eventText"));
		return calendarEvent;
	}
}