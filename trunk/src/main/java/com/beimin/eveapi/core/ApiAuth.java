package com.beimin.eveapi.core;

import java.util.HashMap;
import java.util.Map;

public abstract class ApiAuth<A extends ApiAuth<?>> implements Comparable<A> {

	public abstract int getUserID();

	public abstract Long getCharacterID();

	public abstract void setCharacterID(long characterID);

	public abstract String getApiKey();

	public Map<String, String> getParams() {
		Map<String, String> result = new HashMap<String, String>();
		result.put("userID", Integer.toString(getUserID()));
		if (getCharacterID() != null)
			result.put("characterID", Long.toString(getCharacterID()));
		result.put("apiKey", getApiKey());
		return result;
	}

}