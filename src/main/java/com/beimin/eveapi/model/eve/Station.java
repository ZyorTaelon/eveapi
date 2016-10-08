package com.beimin.eveapi.model.eve;

public class Station {
    private long stationID;
    private String stationName;
    private int stationTypeID;
    private int solarSystemID;
    private int corporationID;
    private String corporationName;

    public long getStationID() {
        return stationID;
    }

    public void setStationID(final long stationID) {
        this.stationID = stationID;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(final String stationName) {
        this.stationName = stationName;
    }

    public int getStationTypeID() {
        return stationTypeID;
    }

    public void setStationTypeID(final int stationTypeID) {
        this.stationTypeID = stationTypeID;
    }

    public int getSolarSystemID() {
        return solarSystemID;
    }

    public void setSolarSystemID(final int solarSystemID) {
        this.solarSystemID = solarSystemID;
    }

    public int getCorporationID() {
        return corporationID;
    }

    public void setCorporationID(final int corporationID) {
        this.corporationID = corporationID;
    }

    public String getCorporationName() {
        return corporationName;
    }

    public void setCorporationName(final String corporationName) {
        this.corporationName = corporationName;
    }
}
