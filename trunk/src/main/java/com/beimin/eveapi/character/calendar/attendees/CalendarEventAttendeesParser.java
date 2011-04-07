package com.beimin.eveapi.character.calendar.attendees;


import org.apache.commons.digester.Digester;

import com.beimin.eveapi.core.AbstractApiParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

public class CalendarEventAttendeesParser extends AbstractApiParser<CalendarEventAttendeesResponse> {
	public CalendarEventAttendeesParser() {
		super(CalendarEventAttendeesResponse.class, 2, ApiPath.CHARACTER, ApiPage.CALENDAR_EVENT_ATTENDEES);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", ApiCalendarEventAttendee.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "add");
		return digester;
	}

	public static CalendarEventAttendeesParser getInstance() {
		return new CalendarEventAttendeesParser();
	}

	@Override
	public CalendarEventAttendeesResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}