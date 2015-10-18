package com.beimin.eveapi.model.shared;

public class Contact {
	private int contactID;
	private String contactName;
	private double standing;
	private boolean inWatchlist;
	private int contactTypeID;
	private int labelMask;

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

	public int getContactTypeID() {
		return contactTypeID;
	}

	public void setContactTypeID(int contactTypeID) {
		this.contactTypeID = contactTypeID;
	}

	public int getLabelMask() {
		return labelMask;
	}

	public void setLabelMask(int labelMask) {
		this.labelMask = labelMask;
	}


}