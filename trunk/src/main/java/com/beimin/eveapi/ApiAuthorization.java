package com.beimin.eveapi;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class ApiAuthorization implements ApiAuth {
	private final int userID;
	private final int characterID;
	private final String apiKey;

	public ApiAuthorization(int userID, int characterID, String apiKey) {
		this.userID = userID;
		this.characterID = characterID;
		this.apiKey = apiKey;
	}

	public int getUserID() {
		return userID;
	}

	public int getCharacterID() {
		return characterID;
	}

	public String getApiKey() {
		return apiKey;
	}

	public String getUrlParams() throws UnsupportedEncodingException {
		String urlParams = "?userID=" + getUserID();
		urlParams += "&characterID=" + getCharacterID();
		urlParams += "&apiKey=" + URLEncoder.encode(getApiKey(), "UTF8");
		return urlParams;
	}
}
