package com.beimin.eveapi.shared.contacts;

public class EveContact {
	private int contactID;
	private String contactName;
	private double standing;
	private boolean inWatchlist;

	public void setContactID(int fromID) {
		this.contactID = fromID;
	}

	public void setContactName(String fromName) {
		this.contactName = fromName;
	}

	public void setStanding(double standing) {
		this.standing = standing;
	}

	public int getContactID() {
		return this.contactID;
	}

	public String getContactName() {
		return this.contactName;
	}

	public double getStanding() {
		return this.standing;
	}

	public boolean isInWatchlist() {
		return inWatchlist;
	}

	public void setInWatchlist(boolean inWatchlist) {
		this.inWatchlist = inWatchlist;
	}
}