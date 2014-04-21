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

	public void setItemID(long itemID) {
		this.itemID = itemID;
	}

	public int getTypeID() {
		return typeID;
	}

	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}

	public int getLocationID() {
		return locationID;
	}

	public void setLocationID(int locationID) {
		this.locationID = locationID;
	}

	public int getMoonID() {
		return moonID;
	}

	public void setMoonID(int moonID) {
		this.moonID = moonID;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public StarbaseState getStarbaseState() {
		return StarbaseState.values()[state];
	}

	public Date getStateTimestamp() {
		return stateTimestamp;
	}

	public void setStateTimestamp(Date stateTimestamp) {
		this.stateTimestamp = stateTimestamp;
	}

	public Date getOnlineTimestamp() {
		return onlineTimestamp;
	}

	public void setOnlineTimestamp(Date onlineTimestamp) {
		this.onlineTimestamp = onlineTimestamp;
	}

	@Override
	public String toString() {
		String result = "Location: " + locationID + " Moon: " + moonID
				+ " TypeID: " + typeID + " State: " + getStarbaseState();
		return result;
	}
}
