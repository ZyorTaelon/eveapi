package com.beimin.eveapi.character.calendar.attendees;


import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.digester.Digester;

import com.beimin.eveapi.core.AbstractListParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.shared.calendar.CalendarEventResponse;
import com.beimin.eveapi.shared.calendar.CalendarEventResponseConverter;
import com.beimin.eveapi.utils.StringUtils;

public class CalendarEventAttendeesParser extends AbstractListParser<CalendarEventAttendeesResponse, ApiCalendarEventAttendee> {
	public CalendarEventAttendeesParser() {
		super(CalendarEventAttendeesResponse.class, 2, ApiPath.CHARACTER, ApiPage.CALENDAR_EVENT_ATTENDEES, ApiCalendarEventAttendee.class);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		ConvertUtils.register(new CalendarEventResponseConverter(), CalendarEventResponse.class);
		return digester;
	}

	public static CalendarEventAttendeesParser getInstance() {
		return new CalendarEventAttendeesParser();
	}

	public CalendarEventAttendeesResponse getResponse(ApiAuth<?> auth, long... eventIDs) throws ApiException {
		return super.getResponse(auth, "eventIDs", StringUtils.join(",", eventIDs));
	}
}