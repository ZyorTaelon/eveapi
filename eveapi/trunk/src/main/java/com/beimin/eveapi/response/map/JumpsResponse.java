package com.beimin.eveapi.response.map;

import java.util.HashMap;
import java.util.Map;

import com.beimin.eveapi.model.map.SystemJumps;
import com.beimin.eveapi.response.ApiListResponse;

public class JumpsResponse extends ApiListResponse<SystemJumps> {
	private static final long serialVersionUID = 1L;
	private final Map<Integer, Integer> systemJumps = new HashMap<Integer, Integer>();

	public void add(SystemJumps systemJump) {
		super.add(systemJump);
		systemJumps.put(systemJump.getSolarSystemID(), systemJump.getShipJumps());
	}

	public Map<Integer, Integer> getSystemJumps() {
		return systemJumps;
	}
}
