package com.beimin.eveapi.response.map;

import java.util.HashMap;
import java.util.Map;

import com.beimin.eveapi.model.map.SystemSovereignty;
import com.beimin.eveapi.response.ApiListResponse;

public class SovereigntyResponse extends ApiListResponse<SystemSovereignty> {
	private static final long serialVersionUID = 1L;
	private final Map<Integer, SystemSovereignty> systemSovereignties = new HashMap<Integer, SystemSovereignty>();

	public void add(SystemSovereignty systemSovereignty) {
		systemSovereignties.put(systemSovereignty.getSolarSystemID(), systemSovereignty);
		super.add(systemSovereignty);
	}

	public Map<Integer, SystemSovereignty> getSystemSovereignties() {
		return systemSovereignties;
	}
}
