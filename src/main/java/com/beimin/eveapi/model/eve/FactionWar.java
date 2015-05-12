package com.beimin.eveapi.model.eve;

public class FactionWar {
	private int factionID;
	private String factionName;
	private int againstID;
	private String againstName;

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

	public int getAgainstID() {
		return againstID;
	}

	public void setAgainstID(int againstID) {
		this.againstID = againstID;
	}

	public String getAgainstName() {
		return againstName;
	}

	public void setAgainstName(String againstName) {
		this.againstName = againstName;
	}
}