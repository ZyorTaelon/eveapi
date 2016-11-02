package com.beimin.eveapi.parser.character;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.character.UpcomingCalendarEventsHandler;
import com.beimin.eveapi.model.character.UpcomingCalendarEvent;
import com.beimin.eveapi.parser.ApiAuth;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractListParser;
import com.beimin.eveapi.response.character.UpcomingCalendarEventsResponse;

public class UpcomingCalendarEventsParser extends AbstractListParser<UpcomingCalendarEventsHandler, UpcomingCalendarEventsResponse, UpcomingCalendarEvent> {
    public UpcomingCalendarEventsParser() {
        super(UpcomingCalendarEventsResponse.class, 2, ApiPath.CHARACTER, ApiPage.UPCOMING_CALENDAR_EVENTS, UpcomingCalendarEventsHandler.class);
    }

    @Override
    public UpcomingCalendarEventsResponse getResponse(final ApiAuth auth) throws ApiException {
        return super.getResponse(auth);
    }
}
