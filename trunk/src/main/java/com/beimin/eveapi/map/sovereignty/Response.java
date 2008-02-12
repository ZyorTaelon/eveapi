package com.beimin.eveapi.map.sovereignty;

import java.util.HashMap;
import java.util.Map;

import com.beimin.eveapi.ApiResponse;

public class Response extends ApiResponse {
	private final Map<Integer, SystemSovereignty> systemSovereignties = new HashMap<Integer, SystemSovereignty>();

	public void addSystemSovereignty(SystemSovereignty systemSovereignty) {
		systemSovereignties.put(systemSovereignty.getSolarSystemID(), systemSovereignty);
	}

	public Map<Integer, SystemSovereignty> getSystemSovereignties() {
		return systemSovereignties;
	}
}
