package com.beimin.eveapi;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public abstract class ApiAuth {

	public abstract int getUserID();

	public abstract long getCharacterID();

	public abstract String getApiKey();

	public String getUrlParams() throws UnsupportedEncodingException {
		String urlParams = "?userID=" + getUserID();
		urlParams += "&characterID=" + getCharacterID();
		urlParams += "&apiKey=" + URLEncoder.encode(getApiKey(), "UTF8");
		return urlParams;
	}
}