package com.beimin.eveapi.utils.stationlist;

public class ApiStation {
	private int stationID;
	private String stationName;
	private int stationTypeID;
	private int solarSystemID;
	private int corporationID;
	private String corporationName;

	public int getStationID() {
		return stationID;
	}

	public void setStationID(int stationID) {
		this.stationID = stationID;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public int getStationTypeID() {
		return stationTypeID;
	}

	public void setStationTypeID(int stationTypeID) {
		this.stationTypeID = stationTypeID;
	}

	public int getSolarSystemID() {
		return solarSystemID;
	}

	public void setSolarSystemID(int solarSystemID) {
		this.solarSystemID = solarSystemID;
	}

	public int getCorporationID() {
		return corporationID;
	}

	public void setCorporationID(int corporationID) {
		this.corporationID = corporationID;
	}

	public String getCorporationName() {
		return corporationName;
	}

	public void setCorporationName(String corporationName) {
		this.corporationName = corporationName;
	}
}
