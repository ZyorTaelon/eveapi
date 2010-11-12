package com.beimin.eveapi.shared.standings;

public class ApiStandingFrom implements ApiStanding {
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
	
	public int getID() {
		return this.fromID;
	}
	
	public String getName() {
		return this.fromName;
	}
	
	public double getStanding() {
		return this.standing;
	}
}