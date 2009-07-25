package com.beimin.eveapi.utils.stationlist;

import java.util.HashMap;
import java.util.Map;

import com.beimin.eveapi.ApiResponse;

public class Response extends ApiResponse {
	private final Map<Integer, ApiStation> stationss = new HashMap<Integer, ApiStation>();

	public void addStation(ApiStation station) {
		stationss.put(station.getStationID(), station);
	}

	public Map<Integer, ApiStation> getStations() {
		return stationss;
	}
}
