package com.beimin.eveapi.handler.pilot;

import java.util.Locale;

import org.xml.sax.Attributes;

import com.beimin.eveapi.handler.AbstractContentListHandler;
import com.beimin.eveapi.model.pilot.CalendarEventAttendee;
import com.beimin.eveapi.response.pilot.CalendarEventAttendeesResponse;
import com.beimin.eveapi.response.pilot.CalendarEventResponse;

public class CalendarEventAttendeesHandler extends AbstractContentListHandler<CalendarEventAttendeesResponse, CalendarEventAttendee> {
    public CalendarEventAttendeesHandler() {
        super(CalendarEventAttendeesResponse.class);
    }

    @Override
    protected CalendarEventAttendee getItem(final Attributes attrs) {
        final CalendarEventAttendee eventAttendee = new CalendarEventAttendee();
        saveAttributes(CalendarEventAttendee.class, attrs);
        eventAttendee.setEventID(getLong(attrs, "eventID"));
        eventAttendee.setCharacterID(getLong(attrs, "characterID"));
        eventAttendee.setCharacterName(getString(attrs, "characterName"));
        eventAttendee.setResponse(CalendarEventResponse.valueOf(getString(attrs, "response").toUpperCase(Locale.ENGLISH)));
        return eventAttendee;
    }
}
