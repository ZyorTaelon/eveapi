package com.beimin.eveapi.character.calendar.attendees;

import com.beimin.eveapi.shared.calendar.CalendarEventResponse;

public class ApiCalendarEventAttendee {
	private long eventID;
	private long characterID;
	private String characterName;
	private CalendarEventResponse response;

	public long getEventID() {
		return eventID;
	}

	public void setEventID(long eventID) {
		this.eventID = eventID;
	}

	public long getCharacterID() {
		return characterID;
	}

	public void setCharacterID(long characterID) {
		this.characterID = characterID;
	}

	public String getCharacterName() {
		return characterName;
	}

	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}
	public CalendarEventResponse getResponse() {
		return response;
	}
	public void setResponse(CalendarEventResponse response) {
		this.response = response;
	}
}