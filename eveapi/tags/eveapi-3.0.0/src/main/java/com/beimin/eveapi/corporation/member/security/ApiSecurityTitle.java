package com.beimin.eveapi.corporation.member.security;

public class ApiSecurityTitle {
	private final long titleID;
	private final String titleName;

	public ApiSecurityTitle(long titleID, String titleName) {
		this.titleID = titleID;
		this.titleName = titleName;
	}

	public long getTitleID() {
		return titleID;
	}

	public String getTitleName() {
		return titleName;
	}
}