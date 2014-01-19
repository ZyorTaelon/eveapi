package com.beimin.eveapi.map.kills;

public class ApiSystemKills {
	private int solarSystemID;
	private int shipKills;
	private int factionKills;
	private int podKills;

	public int getSolarSystemID() {
		return solarSystemID;
	}

	public void setSolarSystemID(int solarSystemID) {
		this.solarSystemID = solarSystemID;
	}

	public int getShipKills() {
		return shipKills;
	}

	public void setShipKills(int shipKills) {
		this.shipKills = shipKills;
	}

	public int getFactionKills() {
		return factionKills;
	}

	public void setFactionKills(int factionKills) {
		this.factionKills = factionKills;
	}

	public int getPodKills() {
		return podKills;
	}

	public void setPodKills(int podKills) {
		this.podKills = podKills;
	}
}
