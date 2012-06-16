package com.beimin.eveapi.character.mail.lists;

public class ApiMailingList {
	private long listID;
	private String displayName;

	public long getListID() {
		return listID;
	}

	public void setListID(long listID) {
		this.listID = listID;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
}