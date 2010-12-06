package com.beimin.eveapi.core;

public enum ApiPath {
	ACCOUNT("/account"), CHARACTER("/char"), CORPORATION("/corp"), EVE("/eve"), MAP("/map"), NONE(""), SERVER("/server");
	private final String path;

	ApiPath(String path) {
		this.path = path;
	}

	public String getPath() {
		return path;
	}
}