package com.beimin.eveapi.shared.standings;

public class ApiStandingTo implements ApiStanding {
	private int toID;
	private String toName;
	private double standing;

	public void setToID(int toID) {
		this.toID = toID;
	}

	public void setToName(String toName) {
		this.toName = toName;
	}

	public void setStanding(double standing) {
		this.standing = standing;
	}

	public int getID() {
		return this.toID;
	}

	public String getName() {
		return this.toName;
	}

	public double getStanding() {
		return this.standing;
	}

}