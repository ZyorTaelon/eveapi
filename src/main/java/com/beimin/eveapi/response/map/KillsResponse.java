package com.beimin.eveapi.response.map;

import java.util.HashMap;
import java.util.Map;

import com.beimin.eveapi.model.map.SystemKills;
import com.beimin.eveapi.response.ApiListResponse;

public class KillsResponse extends ApiListResponse<SystemKills> {
    private final Map<Integer, Integer> shipKills = new HashMap<Integer, Integer>();
    private final Map<Integer, Integer> factionKills = new HashMap<Integer, Integer>();
    private final Map<Integer, Integer> podKills = new HashMap<Integer, Integer>();

    @Override
    public void add(final SystemKills systemKills) {
        shipKills.put(systemKills.getSolarSystemID(), systemKills.getShipKills());
        factionKills.put(systemKills.getSolarSystemID(), systemKills.getFactionKills());
        podKills.put(systemKills.getSolarSystemID(), systemKills.getPodKills());
    }

    public Map<Integer, Integer> getShipKills() {
        return shipKills;
    }

    public Map<Integer, Integer> getFactionKills() {
        return factionKills;
    }

    public Map<Integer, Integer> getPodKills() {
        return podKills;
    }

    @Override
    public String toString() {
        return "KillsResponse [\nshipKills=" + shipKills + ",\nfactionKills=" + factionKills + ",\npodKills=" + podKills + "]";
    }
}
