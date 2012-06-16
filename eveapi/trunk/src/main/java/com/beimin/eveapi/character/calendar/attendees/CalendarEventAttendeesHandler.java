package com.beimin.eveapi.character.calendar.attendees;

import org.xml.sax.Attributes;

import com.beimin.eveapi.character.calendar.CalendarEventResponse;
import com.beimin.eveapi.core.AbstractContentListHandler;

public class CalendarEventAttendeesHandler extends AbstractContentListHandler<CalendarEventAttendeesResponse, EveCalendarEventAttendee> {
	public CalendarEventAttendeesHandler() {
		super(CalendarEventAttendeesResponse.class);
	}

	@Override
	protected EveCalendarEventAttendee getItem(Attributes attrs) {
		EveCalendarEventAttendee eventAttendee = new EveCalendarEventAttendee();
		eventAttendee.setEventID(getInt(attrs, "eventID"));
		eventAttendee.setCharacterID(getInt(attrs, "characterID"));
		eventAttendee.setCharacterName(getString(attrs, "characterName"));
		eventAttendee.setResponse(CalendarEventResponse.valueOf(getString(attrs, "response").toUpperCase()));
		return eventAttendee;
	}
}