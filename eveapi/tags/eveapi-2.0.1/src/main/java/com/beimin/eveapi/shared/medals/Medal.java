package com.beimin.eveapi.shared.medals;

public abstract class Medal {
	private int medalID;
	private String title;
	private String description;

	public int getMedalID() {
		return medalID;
	}

	public void setMedalID(int medalID) {
		this.medalID = medalID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}