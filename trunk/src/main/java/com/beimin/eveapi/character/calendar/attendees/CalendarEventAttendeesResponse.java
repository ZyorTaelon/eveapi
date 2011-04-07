package com.beimin.eveapi.character.calendar.attendees;

import java.util.ArrayList;
import java.util.List;

import com.beimin.eveapi.core.ApiResponse;

public class CalendarEventAttendeesResponse extends ApiResponse {
	private static final long serialVersionUID = 1L;
	private final List<ApiCalendarEventAttendee> calendarEventAttendees = new ArrayList<ApiCalendarEventAttendee>();

	public void add(ApiCalendarEventAttendee event) {
		calendarEventAttendees.add(event);
	}

	public List<ApiCalendarEventAttendee> getCalendarEventAttendees() {
		return calendarEventAttendees;
	}
}