package com.beimin.eveapi.handler.character;

import java.util.Locale;

import org.xml.sax.Attributes;

import com.beimin.eveapi.handler.AbstractContentListHandler;
import com.beimin.eveapi.model.character.CalendarEventAttendee;
import com.beimin.eveapi.response.character.CalendarEventAttendeesResponse;
import com.beimin.eveapi.response.character.CalendarEventResponse;

public class CalendarEventAttendeesHandler extends AbstractContentListHandler<CalendarEventAttendeesResponse, CalendarEventAttendee> {
    public CalendarEventAttendeesHandler() {
        super(new CalendarEventAttendeesResponse());
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
