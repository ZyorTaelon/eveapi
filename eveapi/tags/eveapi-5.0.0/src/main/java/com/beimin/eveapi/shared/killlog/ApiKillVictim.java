package com.beimin.eveapi.shared.killlog;

public class ApiKillVictim {
	private long characterID; // ="411109620"
	private String characterName; // ="Pi'rat Tealon"
	private long corporationID; // ="1449814438"
	private String corporationName; // ="The Bastards"
	private Long allianceID; // ="1311549668"
	private String allianceName; // ="The Bastards."
	private int factionID; // ="0"
	private String factionName; // =""
	private long damageTaken; // ="1415"
	private int shipTypeID; // ="587"

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

	public long getCorporationID() {
		return corporationID;
	}

	public void setCorporationID(long corporationID) {
		this.corporationID = corporationID;
	}

	public String getCorporationName() {
		return corporationName;
	}

	public void setCorporationName(String corporationName) {
		this.corporationName = corporationName;
	}

	public Long getAllianceID() {
		return allianceID;
	}

	public void setAllianceID(Long allianceID) {
		this.allianceID = allianceID;
	}

	public String getAllianceName() {
		return allianceName;
	}

	public void setAllianceName(String allianceName) {
		this.allianceName = allianceName;
	}

	public int getFactionID() {
		return factionID;
	}

	public void setFactionID(int factionID) {
		this.factionID = factionID;
	}

	public String getFactionName() {
		return factionName;
	}

	public void setFactionName(String factionName) {
		this.factionName = factionName;
	}

	public long getDamageTaken() {
		return damageTaken;
	}

	public void setDamageTaken(long damageTaken) {
		this.damageTaken = damageTaken;
	}

	public int getShipTypeID() {
		return shipTypeID;
	}

	public void setShipTypeID(int shipTypeID) {
		this.shipTypeID = shipTypeID;
	}
}