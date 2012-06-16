package com.beimin.eveapi.map.factwar.systems;

public class ApiFacWarSystem {
	private int solarSystemID;
	private String solarSystemName;
	private int occupyingFactionID;
	private String occupyingFactionName;
	private boolean contested;

	public int getSolarSystemID() {
		return solarSystemID;
	}

	public void setSolarSystemID(int solarSystemID) {
		this.solarSystemID = solarSystemID;
	}

	public String getSolarSystemName() {
		return solarSystemName;
	}

	public void setSolarSystemName(String solarSystemName) {
		this.solarSystemName = solarSystemName;
	}

	public int getOccupyingFactionID() {
		return occupyingFactionID;
	}

	public void setOccupyingFactionID(int occupyingFactionID) {
		this.occupyingFactionID = occupyingFactionID;
	}

	public String getOccupyingFactionName() {
		return occupyingFactionName;
	}

	public void setOccupyingFactionName(String occupyingFactionName) {
		this.occupyingFactionName = occupyingFactionName;
	}

	public boolean isContested() {
		return contested;
	}

	public void setContested(boolean contested) {
		this.contested = contested;
	}
}