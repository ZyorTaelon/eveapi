package com.beimin.eveapi.corporation.standings;

import java.util.ArrayList;
import java.util.Collection;

import com.beimin.eveapi.ApiResponse;
import com.beimin.eveapi.shared.standings.StandingsList;

public class StandingsResponse extends ApiResponse {
	private static final long serialVersionUID = 1L;
	private final Collection<StandingsList> corporationStandingsTo = new ArrayList<StandingsList>();
	private final Collection<StandingsList> corporationStandingsFrom = new ArrayList<StandingsList>();
	private final Collection<StandingsList> allianceStandingsTo = new ArrayList<StandingsList>();
	private final Collection<StandingsList> allianceStandingsFrom = new ArrayList<StandingsList>();

	public void addCorporationStandingsToList(StandingsList standingsList) {
		corporationStandingsTo.add(standingsList);
	}

	public void addCorporationStandingsFromList(StandingsList standingsList) {
		corporationStandingsFrom.add(standingsList);
	}

	public void addAllianceStandingsToList(StandingsList standingsList) {
		allianceStandingsTo.add(standingsList);
	}

	public void addAllianceStandingsFromList(StandingsList standingsList) {
		allianceStandingsFrom.add(standingsList);
	}

	public Collection<StandingsList> getCorporationStandingsTo() {
		return corporationStandingsTo;
	}

	public Collection<StandingsList> getCorporationStandingsFrom() {
		return corporationStandingsFrom;
	}

	public Collection<StandingsList> getAllianceStandingsTo() {
		return allianceStandingsTo;
	}

	public Collection<StandingsList> getAllianceStandingsFrom() {
		return allianceStandingsFrom;
	}
}