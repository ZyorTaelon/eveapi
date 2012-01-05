package com.beimin.eveapi.character.calendar.upcomingevents;


import com.beimin.eveapi.core.AbstractListParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

public class UpcomingCalendarEventsParser extends AbstractListParser<UpcomingCalendarEventsHandler, UpcomingCalendarEventsResponse, EveUpcomingCalendarEvent> {
	public UpcomingCalendarEventsParser() {
		super(UpcomingCalendarEventsResponse.class, 2, ApiPath.CHARACTER, ApiPage.UPCOMING_CALENDAR_EVENTS, UpcomingCalendarEventsHandler.class);
	}

	public static UpcomingCalendarEventsParser getInstance() {
		return new UpcomingCalendarEventsParser();
	}

	@Override
	public UpcomingCalendarEventsResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}