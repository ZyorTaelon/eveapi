package com.beimin.eveapi.eve.conquerablestationlist;

import java.util.HashMap;
import java.util.Map;

import com.beimin.eveapi.ApiResponse;

public class StationListResponse extends ApiResponse {
	private static final long serialVersionUID = 1L;
	private final Map<Long, ApiStation> stationss = new HashMap<Long, ApiStation>();

	public void addStation(ApiStation station) {
		stationss.put(station.getStationID(), station);
	}

	public Map<Long, ApiStation> getStations() {
		return stationss;
	}
}
