package com.beimin.eveapi.handler.character;

import java.util.Locale;

import org.xml.sax.Attributes;

import com.beimin.eveapi.handler.AbstractContentListHandler;
import com.beimin.eveapi.model.character.UpcomingCalendarEvent;
import com.beimin.eveapi.response.character.CalendarEventResponse;
import com.beimin.eveapi.response.character.UpcomingCalendarEventsResponse;

public class UpcomingCalendarEventsHandler extends AbstractContentListHandler<UpcomingCalendarEventsResponse, UpcomingCalendarEvent> {

    public UpcomingCalendarEventsHandler() {
        super(UpcomingCalendarEventsResponse.class);
    }

    @Override
    protected UpcomingCalendarEvent getItem(final Attributes attrs) {
        final UpcomingCalendarEvent calendarEvent = new UpcomingCalendarEvent();
        saveAttributes(UpcomingCalendarEvent.class, attrs);
        calendarEvent.setEventID(getLong(attrs, "eventID"));
        calendarEvent.setOwnerID(getLong(attrs, "ownerID"));
        calendarEvent.setOwnerName(getString(attrs, "ownerName"));
        calendarEvent.setEventDate(getDate(attrs, "eventDate"));
        calendarEvent.setEventTitle(getString(attrs, "eventTitle"));
        calendarEvent.setDuration(getInt(attrs, "duration"));
        calendarEvent.setImportance(getInt(attrs, "importance"));
        calendarEvent.setResponse(CalendarEventResponse.valueOf(getString(attrs, "response").toUpperCase(Locale.ENGLISH)));
        calendarEvent.setEventText(getString(attrs, "eventText"));
        calendarEvent.setOwnerTypeID(getInt(attrs, "ownerTypeID"));
        return calendarEvent;
    }
}
