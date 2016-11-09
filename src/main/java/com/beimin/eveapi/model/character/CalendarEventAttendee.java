package com.beimin.eveapi.model.character;


public class CalendarEventAttendee {
    private long eventID;
    private long characterID;
    private String characterName;
    private CalendarEventStatus response;

    public long getEventID() {
        return eventID;
    }

    public void setEventID(final long eventID) {
        this.eventID = eventID;
    }

    public long getCharacterID() {
        return characterID;
    }

    public void setCharacterID(final long characterID) {
        this.characterID = characterID;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(final String characterName) {
        this.characterName = characterName;
    }

    public CalendarEventStatus getResponse() {
        return response;
    }

    public void setResponse(final CalendarEventStatus response) {
        this.response = response;
    }
}
