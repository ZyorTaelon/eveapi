package com.beimin.eveapi.response.eve;

import java.util.HashMap;
import java.util.Map;

import com.beimin.eveapi.model.eve.Station;
import com.beimin.eveapi.response.ApiResponse;

public class StationListResponse extends ApiResponse {
	private static final long serialVersionUID = 1L;
	private final Map<Integer, Station> stations = new HashMap<Integer, Station>();

	public void add(Station station) {
		stations.put(station.getStationID(), station);
	}

	public Map<Integer, Station> getStations() {
		return stations;
	}
}
