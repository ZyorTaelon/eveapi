package com.beimin.eveapi.model.eve;

public abstract class FactionStat implements FacWarStat{
	private int factionID;
	private String factionName;

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
}