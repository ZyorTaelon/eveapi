package com.beimin.eveapi.character.calendar.upcomingevents;


import org.apache.commons.digester.Digester;


import com.beimin.eveapi.core.AbstractApiParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

public class UpcomingCalendarEventsParser extends AbstractApiParser<UpcomingCalendarEventsResponse> {
	public UpcomingCalendarEventsParser() {
		super(UpcomingCalendarEventsResponse.class, 2, ApiPath.CHARACTER, ApiPage.UPCOMING_CALENDAR_EVENTS);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", ApiUpcomingCalendarEvent.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "add");
		return digester;
	}

	public static UpcomingCalendarEventsParser getInstance() {
		return new UpcomingCalendarEventsParser();
	}

	@Override
	public UpcomingCalendarEventsResponse getResponse(ApiAuth auth) throws ApiException {
		return super.getResponse(auth);
	}
}