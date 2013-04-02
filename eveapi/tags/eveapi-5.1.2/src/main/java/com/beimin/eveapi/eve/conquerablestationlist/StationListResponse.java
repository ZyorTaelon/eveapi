package com.beimin.eveapi.eve.conquerablestationlist;

import java.util.HashMap;
import java.util.Map;

import com.beimin.eveapi.core.ApiResponse;

public class StationListResponse extends ApiResponse {
	private static final long serialVersionUID = 1L;
	private final Map<Integer, ApiStation> stations = new HashMap<Integer, ApiStation>();

	public void add(ApiStation station) {
		stations.put(station.getStationID(), station);
	}

	public Map<Integer, ApiStation> getStations() {
		return stations;
	}
}
