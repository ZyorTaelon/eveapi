package com.beimin.eveapi.shared.killlog;

public class ApiKillAttacker {
	private long characterID; // ="1134301496"
	private String characterName; // ="Blackfiredaemon"
	private long corporationID; // ="1885670269"
	private String corporationName; // ="Letiferi Praedones"
	private Long allianceID; // ="1652934118"
	private String allianceName; // ="Wong Thong Crew"
	private int factionID; // ="0"
	private String factionName; // =""
	private double securityStatus; // ="-3.72675620703378"
	private int damageDone; // ="1415"
	private boolean finalBlow; // ="1"
	private int weaponTypeID; // ="2897"
	private int shipTypeID; // ="11999"

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

	public double getSecurityStatus() {
		return securityStatus;
	}

	public void setSecurityStatus(double securityStatus) {
		this.securityStatus = securityStatus;
	}

	public int getDamageDone() {
		return damageDone;
	}

	public void setDamageDone(int damageDone) {
		this.damageDone = damageDone;
	}

	public boolean isFinalBlow() {
		return finalBlow;
	}

	public void setFinalBlow(boolean finalBlow) {
		this.finalBlow = finalBlow;
	}

	public int getWeaponTypeID() {
		return weaponTypeID;
	}

	public void setWeaponTypeID(int weaponTypeID) {
		this.weaponTypeID = weaponTypeID;
	}

	public int getShipTypeID() {
		return shipTypeID;
	}

	public void setShipTypeID(int shipTypeID) {
		this.shipTypeID = shipTypeID;
	}
}