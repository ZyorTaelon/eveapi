package com.beimin.eveapi.character.calendar.upcomingevents;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;

public class UpcomingCalendarEventsParser extends AbstractApiParser<UpcomingCalendarEventsResponse> {
	private static final String UPCOMING_CALENDAR_EVENTS_URL = "/UpcomingCalendarEvents";

	public UpcomingCalendarEventsParser() {
		super(UpcomingCalendarEventsResponse.class, 2, Path.CHARACTER, UPCOMING_CALENDAR_EVENTS_URL);
	}

	public UpcomingCalendarEventsResponse getUpcomingCalendarEvents(ApiAuth auth) throws IOException, SAXException {
		return getResponse(auth);
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
}