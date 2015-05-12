package com.beimin.eveapi.parser;

import java.util.HashMap;
import java.util.Map;

public abstract class ApiAuth<A extends ApiAuth<?>> implements Comparable<A> {

	public abstract int getKeyID();

	public abstract Long getCharacterID();

	public abstract void setCharacterID(long characterID);

	public abstract String getVCode();

	public Map<String, String> getParams() {
		Map<String, String> result = new HashMap<String, String>();
		result.put("keyID", Integer.toString(getKeyID()));
		if (getCharacterID() != null)
			result.put("characterID", Long.toString(getCharacterID()));
		result.put("vCode", getVCode());
		return result;
	}

}