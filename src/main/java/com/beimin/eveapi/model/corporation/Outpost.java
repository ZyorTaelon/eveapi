package com.beimin.eveapi.model.corporation;

public class Outpost {
    private long stationID;
    private long ownerID;
    private long standingOwnerID;
    private String stationName;
    private int solarSystemID;
    private int stationTypeID;
    private double dockingCostPerShipVolume;
    private double officeRentalCost;
    private double reprocessingEfficiency;
    private double reprocessingStationTake;

    public long getStationID() {
        return stationID;
    }

    public void setStationID(final long stationID) {
        this.stationID = stationID;
    }

    public long getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(final long ownerID) {
        this.ownerID = ownerID;
    }

    public long getStandingOwnerID() {
        return standingOwnerID;
    }

    public void setStandingOwnerID(final long standingOwnerID) {
        this.standingOwnerID = standingOwnerID;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(final String stationName) {
        this.stationName = stationName;
    }

    public int getSolarSystemID() {
        return solarSystemID;
    }

    public void setSolarSystemID(final int solarSystemID) {
        this.solarSystemID = solarSystemID;
    }

    public int getStationTypeID() {
        return stationTypeID;
    }

    public void setStationTypeID(final int stationTypeID) {
        this.stationTypeID = stationTypeID;
    }

    public double getDockingCostPerShipVolume() {
        return dockingCostPerShipVolume;
    }

    public void setDockingCostPerShipVolume(final double dockingCostPerShipVolume) {
        this.dockingCostPerShipVolume = dockingCostPerShipVolume;
    }

    public double getOfficeRentalCost() {
        return officeRentalCost;
    }

    public void setOfficeRentalCost(final double officeRentalCost) {
        this.officeRentalCost = officeRentalCost;
    }

    public double getReprocessingEfficiency() {
        return reprocessingEfficiency;
    }

    public void setReprocessingEfficiency(final double reprocessingEfficiency) {
        this.reprocessingEfficiency = reprocessingEfficiency;
    }

    public double getReprocessingStationTake() {
        return reprocessingStationTake;
    }

    public void setReprocessingStationTake(final double reprocessingStationTake) {
        this.reprocessingStationTake = reprocessingStationTake;
    }
}