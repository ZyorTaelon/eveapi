package com.beimin.eveapi.map.jumps;

import java.util.HashMap;
import java.util.Map;

import com.beimin.eveapi.core.ApiResponse;

public class MapJumpsResponse extends ApiResponse {
	private static final long serialVersionUID = 1L;
	private final Map<Integer, Integer> systemJumps = new HashMap<Integer, Integer>();

	public void add(ApiSystemJumps systemJump) {
		systemJumps.put(systemJump.getSolarSystemID(),
				systemJump.getShipJumps());
	}

	public Map<Integer, Integer> getSystemJumps() {
		return systemJumps;
	}
}
