package com.beimin.eveapi.model.pilot;

import java.util.Date;

import com.beimin.eveapi.response.pilot.CalendarEventResponse;

public class UpcomingCalendarEvent {
    private long eventID;
    private long ownerID;
    private String ownerName;
    private Date eventDate;
    private String eventTitle;
    private int duration;
    private boolean important;
    private CalendarEventResponse response;
    private String eventText;

    public long getEventID() {
        return eventID;
    }

    public void setEventID(final long eventID) {
        this.eventID = eventID;
    }

    public long getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(final long ownerID) {
        this.ownerID = ownerID;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(final String ownerName) {
        this.ownerName = ownerName;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(final Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(final String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(final int duration) {
        this.duration = duration;
    }

    public boolean isImportant() {
        return important;
    }

    public void setImportance(final int importance) {
        important = importance == 1;
    }

    public CalendarEventResponse getResponse() {
        return response;
    }

    public void setResponse(final CalendarEventResponse response) {
        this.response = response;
    }

    public String getEventText() {
        return eventText;
    }

    public void setEventText(final String eventText) {
        this.eventText = eventText;
    }
}
