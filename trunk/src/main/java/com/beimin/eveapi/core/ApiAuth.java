package com.beimin.eveapi.core;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public abstract class ApiAuth implements Comparable<ApiAuth> {

	public abstract int getUserID();

	public abstract long getCharacterID();

	public abstract String getApiKey();

	public Map<String, String> getParams() throws UnsupportedEncodingException {
		Map<String, String> result = new HashMap<String, String>();
		result.put("userID", Integer.toString(getUserID()));
		result.put("characterID", Long.toString(getCharacterID()));
		result.put("apiKey", URLEncoder.encode(getApiKey(), "UTF8"));
		return result;
	}
}