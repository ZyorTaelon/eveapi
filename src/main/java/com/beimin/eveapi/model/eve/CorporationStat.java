package com.beimin.eveapi.model.eve;

public abstract class CorporationStat implements FacWarStat {
	private long corporationID;
	private String corporationName;

	public long getCorporationID() {
		return corporationID;
	}

	public void setCorporationID(long corporationID) {
		this.corporationID = corporationID;
	}

	public String getCorporationName() {
		return corporationName;
	}

	public void setCorporationName(String corporationName) {
		this.corporationName = corporationName;
	}
}