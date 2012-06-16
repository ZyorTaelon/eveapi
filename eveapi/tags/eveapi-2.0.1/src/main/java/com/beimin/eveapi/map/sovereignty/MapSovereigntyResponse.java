package com.beimin.eveapi.map.sovereignty;

import java.util.HashMap;
import java.util.Map;

import com.beimin.eveapi.ApiResponse;

public class MapSovereigntyResponse extends ApiResponse {
	private final Map<Integer, ApiSystemSovereignty> systemSovereignties = new HashMap<Integer, ApiSystemSovereignty>();

	public void addSystemSovereignty(ApiSystemSovereignty systemSovereignty) {
		systemSovereignties.put(systemSovereignty.getSolarSystemID(), systemSovereignty);
	}

	public Map<Integer, ApiSystemSovereignty> getSystemSovereignties() {
		return systemSovereignties;
	}
}
