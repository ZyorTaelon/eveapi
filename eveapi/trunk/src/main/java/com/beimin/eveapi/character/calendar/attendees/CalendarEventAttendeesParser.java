package com.beimin.eveapi.character.calendar.attendees;


import com.beimin.eveapi.core.AbstractListParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.utils.StringUtils;

public class CalendarEventAttendeesParser extends AbstractListParser<CalendarEventAttendeesHandler, CalendarEventAttendeesResponse, EveCalendarEventAttendee> {
	public CalendarEventAttendeesParser() {
		super(CalendarEventAttendeesResponse.class, 2, ApiPath.CHARACTER, ApiPage.CALENDAR_EVENT_ATTENDEES, CalendarEventAttendeesHandler.class);
	}

	public CalendarEventAttendeesResponse getResponse(ApiAuth<?> auth, long... eventIDs) throws ApiException {
		if (eventIDs.length == 0)
			throw new ApiException("no eventIds provided");
		return super.getResponse(auth, "eventIDs", StringUtils.join(",", eventIDs));
	}
}