package com.beimin.eveapi.utils.stationlist;

import java.util.HashMap;
import java.util.Map;

import com.beimin.eveapi.ApiResponse;

public class Response extends ApiResponse {
	private final Map<Integer, Station> stationss = new HashMap<Integer, Station>();

	public void addStation(Station station) {
		stationss.put(station.getStationID(), station);
	}

	public Map<Integer, Station> getStations() {
		return stationss;
	}
}
