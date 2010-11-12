package com.beimin.eveapi.map.sovereignty;


public class ApiSystemSovereignty {
	private int solarSystemID;
	private int allianceID;
	private int corporationID;
	private int factionID;
	private String solarSystemName;
	
	public int getSolarSystemID() {
		return solarSystemID;
	}

	public void setSolarSystemID(int solarSystemID) {
		this.solarSystemID = solarSystemID;
	}

	public int getAllianceID() {
		return allianceID;
	}

	public void setAllianceID(int allianceID) {
		this.allianceID = allianceID;
	}

	public int getCorporationID() {
		return corporationID;
	}

	public void setCorporationID(int corporationID) {
		this.corporationID = corporationID;
	}

	public int getFactionID() {
		return factionID;
	}

	public void setFactionID(int factionID) {
		this.factionID = factionID;
	}

	public String getSolarSystemName() {
		return solarSystemName;
	}

	public void setSolarSystemName(String solarSystemName) {
		this.solarSystemName = solarSystemName;
	}
}
