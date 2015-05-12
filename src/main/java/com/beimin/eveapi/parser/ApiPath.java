package com.beimin.eveapi.parser;

public enum ApiPath {
	ACCOUNT("/account"), CHARACTER("/char"), CORPORATION("/corp"),
	EVE("/eve"), MAP("/map"), API("/api"), NONE(""), SERVER("/server"),
	;
	private final String path;

	ApiPath(String path) {
		this.path = path;
	}

	public String getPath() {
		return path;
	}
}