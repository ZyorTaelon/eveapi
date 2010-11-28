package com.beimin.eveapi.shared.standings;

import com.beimin.eveapi.ApiResponse;

public class StandingsResponse extends ApiResponse {
	private static final long serialVersionUID = 2L;
	private StandingsList agentStandings;
	private StandingsList npcCorporationStandings;
	private StandingsList factionStandings;

	public void addStandingsList(StandingsList standingsList) {
		if (standingsList.getName().equals("agents"))
			agentStandings = standingsList;
		else if (standingsList.getName().equals("NPCCorporations"))
			npcCorporationStandings = standingsList;
		else if (standingsList.getName().equals("factions"))
			factionStandings = standingsList;
		else
			throw new RuntimeException("Unknown standings list type");
	}

	public StandingsList getAgentStandings() {
		return agentStandings;
	}

	public StandingsList getNpcCorporationStandings() {
		return npcCorporationStandings;
	}

	public StandingsList getFactionStandings() {
		return factionStandings;
	}
}