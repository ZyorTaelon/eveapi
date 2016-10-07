package com.beimin.eveapi.model.corporation;

import java.util.Date;

public class Starbase {
    private long itemID;
    private int typeID;
    private int locationID;
    private int moonID;
    private int state;
    private Date stateTimestamp;
    private Date onlineTimestamp;

    public long getItemID() {
        return itemID;
    }

    public void setItemID(final long itemID) {
        this.itemID = itemID;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(final int typeID) {
        this.typeID = typeID;
    }

    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(final int locationID) {
        this.locationID = locationID;
    }

    public int getMoonID() {
        return moonID;
    }

    public void setMoonID(final int moonID) {
        this.moonID = moonID;
    }

    public int getState() {
        return state;
    }

    public void setState(final int state) {
        this.state = state;
    }

    public StarbaseState getStarbaseState() {
        return StarbaseState.values()[state];
    }

    public Date getStateTimestamp() {
        return stateTimestamp;
    }

    public void setStateTimestamp(final Date stateTimestamp) {
        this.stateTimestamp = stateTimestamp;
    }

    public Date getOnlineTimestamp() {
        return onlineTimestamp;
    }

    public void setOnlineTimestamp(final Date onlineTimestamp) {
        this.onlineTimestamp = onlineTimestamp;
    }

    @Override
    public String toString() {
        final String result = "Location: " + locationID + " Moon: " + moonID + " TypeID: " + typeID + " State: " + getStarbaseState();
        return result;
    }
}
