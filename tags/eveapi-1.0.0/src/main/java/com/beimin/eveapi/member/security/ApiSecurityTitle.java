package com.beimin.eveapi.member.security;

public class ApiSecurityTitle {
	private final int titleID;
	private final String titleName;

	public ApiSecurityTitle(int titleID, String titleName) {
		this.titleID = titleID;
		this.titleName = titleName;
	}

	public int getTitleID() {
		return titleID;
	}

	public String getTitleName() {
		return titleName;
	}
}