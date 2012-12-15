package com.beimin.eveapi.corporation.outpost.list;


public class ApiOutpost {
	private int stationID;
	private long ownerID;
	private long standingOwnerID;
	private String stationName;
	private int solarSystemID;
	private int stationTypeID;
	private double dockingCostPerShipVolume;
	private double officeRentalCost;
	private double reprocessingEfficiency;
	private double reprocessingStationTake;

	public int getStationID() {
		return stationID;
	}

	public void setStationID(int stationID) {
		this.stationID = stationID;
	}

	public long getOwnerID() {
		return ownerID;
	}

	public void setOwnerID(long ownerID) {
		this.ownerID = ownerID;
	}

	public long getStandingOwnerID() {
		return standingOwnerID;
	}

	public void setStandingOwnerID(long standingOwnerID) {
		this.standingOwnerID = standingOwnerID;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public int getSolarSystemID() {
		return solarSystemID;
	}

	public void setSolarSystemID(int solarSystemID) {
		this.solarSystemID = solarSystemID;
	}

	public int getStationTypeID() {
		return stationTypeID;
	}

	public void setStationTypeID(int stationTypeID) {
		this.stationTypeID = stationTypeID;
	}

	public double getDockingCostPerShipVolume() {
		return dockingCostPerShipVolume;
	}

	public void setDockingCostPerShipVolume(double dockingCostPerShipVolume) {
		this.dockingCostPerShipVolume = dockingCostPerShipVolume;
	}

	public double getOfficeRentalCost() {
		return officeRentalCost;
	}

	public void setOfficeRentalCost(double officeRentalCost) {
		this.officeRentalCost = officeRentalCost;
	}

	public double getReprocessingEfficiency() {
		return reprocessingEfficiency;
	}

	public void setReprocessingEfficiency(double reprocessingEfficiency) {
		this.reprocessingEfficiency = reprocessingEfficiency;
	}

	public double getReprocessingStationTake() {
		return reprocessingStationTake;
	}

	public void setReprocessingStationTake(double reprocessingStationTake) {
		this.reprocessingStationTake = reprocessingStationTake;
	}
}