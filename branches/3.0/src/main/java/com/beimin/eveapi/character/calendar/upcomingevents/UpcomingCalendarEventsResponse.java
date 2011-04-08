package com.beimin.eveapi.character.calendar.upcomingevents;

import java.util.ArrayList;
import java.util.List;

import com.beimin.eveapi.core.ApiResponse;

public class UpcomingCalendarEventsResponse extends ApiResponse {
	private static final long serialVersionUID = 1L;
	private final List<ApiUpcomingCalendarEvent> upcomingCalendarEvents = new ArrayList<ApiUpcomingCalendarEvent>();

	public void add(ApiUpcomingCalendarEvent event) {
		upcomingCalendarEvents.add(event);
	}

	public List<ApiUpcomingCalendarEvent> getUpcomingCalendarEvents() {
		return upcomingCalendarEvents;
	}
}