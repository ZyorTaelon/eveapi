package com.beimin.eveapi.response.eve;

import com.beimin.eveapi.model.eve.Station;
import com.beimin.eveapi.response.ApiResponse;

import java.util.HashMap;
import java.util.Map;

public class StationListResponse extends ApiResponse {
    private final Map<Long, Station> stations = new HashMap<Long, Station>();

    public void add(Station station) {
        stations.put(station.getStationID(), station);
    }

    public Map<Long, Station> getStations() {
        return stations;
    }
}
