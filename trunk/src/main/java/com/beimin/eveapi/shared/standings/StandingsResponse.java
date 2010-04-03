package com.beimin.eveapi.shared.standings;

import java.util.ArrayList;
import java.util.Collection;

import com.beimin.eveapi.ApiResponse;

public class StandingsResponse extends ApiResponse {
	private final Collection<StandingsList> corporationStandingsTo = new ArrayList<StandingsList>();
	private final Collection<StandingsList> corporationStandingsFrom = new ArrayList<StandingsList>();
	private final Collection<StandingsList> allianceStandingsTo = new ArrayList<StandingsList>();
	private final Collection<StandingsList> allianceStandingsFrom = new ArrayList<StandingsList>();
	private final Collection<StandingsList> characterStandingsTo = new ArrayList<StandingsList>();
	private final Collection<StandingsList> characterStandingsFrom = new ArrayList<StandingsList>();
	
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

	public void addCharacterStandingsToList(StandingsList standingsList) {
		characterStandingsTo.add(standingsList);
	}
	
	public void addCharacterStandingsFromList(StandingsList standingsList) {
		characterStandingsFrom.add(standingsList);
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

	public Collection<StandingsList> getCharacterStandingsTo() {
		return characterStandingsTo;
	}

	public Collection<StandingsList> getCharacterStandingsFrom() {
		return characterStandingsFrom;
	}
}