package com.beimin.eveapi.model.shared;

public class Standing {
	private int fromID;
	private String fromName;
	private double standing;

	public void setFromID(int fromID) {
		this.fromID = fromID;
	}

	public void setFromName(String fromName) {
		this.fromName = fromName;
	}

	public void setStanding(double standing) {
		this.standing = standing;
	}

	public int getFromID() {
		return this.fromID;
	}

	public String getFromName() {
		return this.fromName;
	}

	public double getStanding() {
		return this.standing;
	}
}