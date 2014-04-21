package com.beimin.eveapi.parser.pilot;


import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.pilot.UpcomingCalendarEventsHandler;
import com.beimin.eveapi.model.pilot.UpcomingCalendarEvent;
import com.beimin.eveapi.parser.ApiAuth;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractListParser;
import com.beimin.eveapi.response.pilot.UpcomingCalendarEventsResponse;

public class UpcomingCalendarEventsParser extends AbstractListParser<UpcomingCalendarEventsHandler, UpcomingCalendarEventsResponse, UpcomingCalendarEvent> {
	public UpcomingCalendarEventsParser() {
		super(UpcomingCalendarEventsResponse.class, 2, ApiPath.CHARACTER, ApiPage.UPCOMING_CALENDAR_EVENTS, UpcomingCalendarEventsHandler.class);
	}

	@Override
	public UpcomingCalendarEventsResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}