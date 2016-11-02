package com.beimin.eveapi.model.character;

import com.beimin.eveapi.response.character.CalendarEventResponse;

public class CalendarEventAttendee {
    private long eventID;
    private long characterID;
    private String characterName;
    private CalendarEventResponse response;

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

    public CalendarEventResponse getResponse() {
        return response;
    }

    public void setResponse(final CalendarEventResponse response) {
        this.response = response;
    }
}
