package com.beimin.eveapi.response.shared;

import com.beimin.eveapi.model.shared.NamedList;
import com.beimin.eveapi.model.shared.Standing;
import com.beimin.eveapi.response.ApiResponse;

public class StandingsResponse extends ApiResponse {
    private NamedList<Standing> agentStandings;
    private NamedList<Standing> npcCorporationStandings;
    private NamedList<Standing> factionStandings;

    public void addStandingsList(final NamedList<Standing> standingsList) {
        if (standingsList.getName().equals("agents")) {
            agentStandings = standingsList;
        } else if (standingsList.getName().equals("NPCCorporations")) {
            npcCorporationStandings = standingsList;
        } else if (standingsList.getName().equals("factions")) {
            factionStandings = standingsList;
        } else {
            throw new RuntimeException("Unknown standings list type");
        }
    }

    public NamedList<Standing> getAgentStandings() {
        return agentStandings;
    }

    public NamedList<Standing> getNpcCorporationStandings() {
        return npcCorporationStandings;
    }

    public NamedList<Standing> getFactionStandings() {
        return factionStandings;
    }
}
