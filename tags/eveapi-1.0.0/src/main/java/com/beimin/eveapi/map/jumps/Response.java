package com.beimin.eveapi.map.jumps;

import java.util.HashMap;
import java.util.Map;

import com.beimin.eveapi.ApiResponse;

public class Response extends ApiResponse {
	private final Map<Integer, Integer> systemJumps = new HashMap<Integer, Integer>();

	public void addSystemJumps(ApiSystemJumps systemJump) {
		systemJumps.put(systemJump.getSolarSystemID(), systemJump.getShipJumps());
	}

	public Map<Integer, Integer> getSystemJumps() {
		return systemJumps;
	}
}
