package com.beimin.eveapi.character.list;

public class ApiCharacter {
	private String name;
	private long characterID;
	private String corporationName;
	private long corporationID;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getCharacterID() {
		return characterID;
	}

	public void setCharacterID(long characterID) {
		this.characterID = characterID;
	}

	public String getCorporationName() {
		return corporationName;
	}

	public void setCorporationName(String corporationName) {
		this.corporationName = corporationName;
	}

	public long getCorporationID() {
		return corporationID;
	}

	public void setCorporationID(long corporationID) {
		this.corporationID = corporationID;
	}
}