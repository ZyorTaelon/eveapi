package com.beimin.eveapi.character.calendar.upcomingevents;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;
import com.beimin.eveapi.ApiPage;
import com.beimin.eveapi.ApiPath;

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
	public UpcomingCalendarEventsResponse getResponse(ApiAuth auth) throws IOException, SAXException {
		return super.getResponse(auth);
	}
}