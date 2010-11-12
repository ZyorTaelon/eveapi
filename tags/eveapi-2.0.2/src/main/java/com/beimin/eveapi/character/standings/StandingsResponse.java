package com.beimin.eveapi.character.standings;

import java.util.ArrayList;
import java.util.Collection;

import com.beimin.eveapi.ApiResponse;
import com.beimin.eveapi.shared.standings.StandingsList;

public class StandingsResponse extends ApiResponse {
	private final Collection<StandingsList> standingsTo = new ArrayList<StandingsList>();
	private final Collection<StandingsList> standingsFrom = new ArrayList<StandingsList>();
	
	public void addStandingsToList(StandingsList standingsList) {
		standingsTo.add(standingsList);
	}
	
	public void addStandingsFromList(StandingsList standingsList) {
		standingsFrom.add(standingsList);
	}

	public Collection<StandingsList> getStandingsTo() {
		return standingsTo;
	}

	public Collection<StandingsList> getStandingsFrom() {
		return standingsFrom;
	}
}