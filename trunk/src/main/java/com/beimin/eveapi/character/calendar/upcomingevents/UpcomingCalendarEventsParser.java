package com.beimin.eveapi.character.calendar.upcomingevents;


import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.digester.Digester;

import com.beimin.eveapi.core.AbstractListParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.shared.calendar.CalendarEventResponse;
import com.beimin.eveapi.shared.calendar.CalendarEventResponseConverter;

public class UpcomingCalendarEventsParser extends AbstractListParser<UpcomingCalendarEventsResponse, ApiUpcomingCalendarEvent> {
	public UpcomingCalendarEventsParser() {
		super(UpcomingCalendarEventsResponse.class, 2, ApiPath.CHARACTER, ApiPage.UPCOMING_CALENDAR_EVENTS, ApiUpcomingCalendarEvent.class);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		ConvertUtils.register(new CalendarEventResponseConverter(), CalendarEventResponse.class);
		return digester;
	}

	public static UpcomingCalendarEventsParser getInstance() {
		return new UpcomingCalendarEventsParser();
	}

	@Override
	public UpcomingCalendarEventsResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}