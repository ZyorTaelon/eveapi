package com.beimin.eveapi.shared.standings;

import java.util.ArrayList;
import java.util.Collection;

import com.beimin.eveapi.ApiResponse;

public class StandingsResponse extends ApiResponse {
	private static final long serialVersionUID = 2L;
	private final Collection<StandingsList> standingsLists = new ArrayList<StandingsList>();

	public void addStandingsList(StandingsList standingsList) {
		standingsLists.add(standingsList);
	}

	public Collection<StandingsList> getStandingsLists() {
		return standingsLists;
	}
}