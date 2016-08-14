package com.beimin.eveapi.model.account;

public class Character {
	private String name;
	private long characterID;
	private String corporationName;
	private long corporationID;
	private String allianceName;
	private long allianceID;
	private String factionName;
	private long factionID;

	public long getAllianceID() {
		return allianceID;
	}

	public void setAllianceID(long allianceID) {
		this.allianceID = allianceID;
	}

	public String getAllianceName() {
		return allianceName;
	}

	public void setAllianceName(String allianceName) {
		this.allianceName = allianceName;
	}

	public long getFactionID() {
		return factionID;
	}

	public void setFactionID(long factionID) {
		this.factionID = factionID;
	}

	public String getFactionName() {
		return factionName;
	}

	public void setFactionName(String factionName) {
		this.factionName = factionName;
	}

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