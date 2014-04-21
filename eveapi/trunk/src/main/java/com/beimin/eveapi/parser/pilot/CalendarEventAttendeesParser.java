package com.beimin.eveapi.parser.pilot;


import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.pilot.CalendarEventAttendeesHandler;
import com.beimin.eveapi.model.pilot.CalendarEventAttendee;
import com.beimin.eveapi.parser.ApiAuth;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractListParser;
import com.beimin.eveapi.response.pilot.CalendarEventAttendeesResponse;
import com.beimin.eveapi.utils.StringUtils;

public class CalendarEventAttendeesParser extends AbstractListParser<CalendarEventAttendeesHandler, CalendarEventAttendeesResponse, CalendarEventAttendee> {
	public CalendarEventAttendeesParser() {
		super(CalendarEventAttendeesResponse.class, 2, ApiPath.CHARACTER, ApiPage.CALENDAR_EVENT_ATTENDEES, CalendarEventAttendeesHandler.class);
	}

	public CalendarEventAttendeesResponse getResponse(ApiAuth<?> auth, long... eventIDs) throws ApiException {
		if (eventIDs.length == 0)
			throw new ApiException("no eventIds provided");
		return super.getResponse(auth, "eventIDs", StringUtils.join(",", eventIDs));
	}
}