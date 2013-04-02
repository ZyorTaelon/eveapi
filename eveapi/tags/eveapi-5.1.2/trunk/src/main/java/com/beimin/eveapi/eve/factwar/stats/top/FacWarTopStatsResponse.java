package com.beimin.eveapi.eve.factwar.stats.top;

import java.util.ArrayList;
import java.util.List;

import com.beimin.eveapi.core.ApiResponse;

public class FacWarTopStatsResponse extends ApiResponse {
	private static final long serialVersionUID = 1L;
	private final List<CharacterKills> characterKillsYesterday = new ArrayList<CharacterKills>();
	private final List<CharacterKills> characterKillsLastWeek = new ArrayList<CharacterKills>();
	private final List<CharacterKills> characterKillsTotal = new ArrayList<CharacterKills>();
	private final List<CharacterVictoryPoints> characterVictoryPointsYesterday = new ArrayList<CharacterVictoryPoints>();
	private final List<CharacterVictoryPoints> characterVictoryPointsLastWeek = new ArrayList<CharacterVictoryPoints>();
	private final List<CharacterVictoryPoints> characterVictoryPointsTotal = new ArrayList<CharacterVictoryPoints>();
	private final List<CorporationKills> corporationKillsYesterday = new ArrayList<CorporationKills>();
	private final List<CorporationKills> corporationKillsLastWeek = new ArrayList<CorporationKills>();
	private final List<CorporationKills> corporationKillsTotal = new ArrayList<CorporationKills>();
	private final List<CorporationVictoryPoints> corporationVictoryPointsYesterday = new ArrayList<CorporationVictoryPoints>();
	private final List<CorporationVictoryPoints> corporationVictoryPointsLastWeek = new ArrayList<CorporationVictoryPoints>();
	private final List<CorporationVictoryPoints> corporationVictoryPointsTotal = new ArrayList<CorporationVictoryPoints>();
	private final List<FactionKills> factionKillsYesterday = new ArrayList<FactionKills>();
	private final List<FactionKills> factionKillsLastWeek = new ArrayList<FactionKills>();
	private final List<FactionKills> factionKillsTotal = new ArrayList<FactionKills>();
	private final List<FactionVictoryPoints> factionVictoryPointsYesterday = new ArrayList<FactionVictoryPoints>();
	private final List<FactionVictoryPoints> factionVictoryPointsLastWeek = new ArrayList<FactionVictoryPoints>();
	private final List<FactionVictoryPoints> factionVictoryPointsTotal = new ArrayList<FactionVictoryPoints>();
	
	public void addYesterday(FacWarStat stat) {
		if (stat instanceof CharacterKills) {
			characterKillsYesterday.add((CharacterKills) stat);
		} else if (stat instanceof CharacterVictoryPoints) {
			characterVictoryPointsYesterday.add((CharacterVictoryPoints) stat);
		} else if (stat instanceof CorporationKills) {
			corporationKillsYesterday.add((CorporationKills) stat);
		} else if (stat instanceof CorporationVictoryPoints) {
			corporationVictoryPointsYesterday.add((CorporationVictoryPoints) stat);
		} else if (stat instanceof FactionKills) {
			factionKillsYesterday.add((FactionKills) stat);
		} else if (stat instanceof FactionVictoryPoints) {
			factionVictoryPointsYesterday.add((FactionVictoryPoints) stat);
		}
	}

	public void addLastWeek(FacWarStat stat) {
		if (stat instanceof CharacterKills) {
			characterKillsLastWeek.add((CharacterKills) stat);
		} else if (stat instanceof CharacterVictoryPoints) {
			characterVictoryPointsLastWeek.add((CharacterVictoryPoints) stat);
		} else if (stat instanceof CorporationKills) {
			corporationKillsLastWeek.add((CorporationKills) stat);
		} else if (stat instanceof CorporationVictoryPoints) {
			corporationVictoryPointsLastWeek.add((CorporationVictoryPoints) stat);
		} else if (stat instanceof FactionKills) {
			factionKillsLastWeek.add((FactionKills) stat);
		} else if (stat instanceof FactionVictoryPoints) {
			factionVictoryPointsLastWeek.add((FactionVictoryPoints) stat);
		}
	}

	public void addTotal(FacWarStat stat) {
		if (stat instanceof CharacterKills) {
			characterKillsTotal.add((CharacterKills) stat);
		} else if (stat instanceof CharacterVictoryPoints) {
			characterVictoryPointsTotal.add((CharacterVictoryPoints) stat);
		} else if (stat instanceof CorporationKills) {
			corporationKillsTotal.add((CorporationKills) stat);
		} else if (stat instanceof CorporationVictoryPoints) {
			corporationVictoryPointsTotal.add((CorporationVictoryPoints) stat);
		} else if (stat instanceof FactionKills) {
			factionKillsTotal.add((FactionKills) stat);
		} else if (stat instanceof FactionVictoryPoints) {
			factionVictoryPointsTotal.add((FactionVictoryPoints) stat);
		}
	}
	
	public List<CharacterKills> getCharacterKillsYesterday() {
		return characterKillsYesterday;
	}

	public List<CharacterKills> getCharacterKillsLastWeek() {
		return characterKillsLastWeek;
	}

	public List<CharacterKills> getCharacterKillsTotal() {
		return characterKillsTotal;
	}

	public List<CharacterVictoryPoints> getCharacterVictoryPointsYesterday() {
		return characterVictoryPointsYesterday;
	}

	public List<CharacterVictoryPoints> getCharacterVictoryPointsLastWeek() {
		return characterVictoryPointsLastWeek;
	}

	public List<CharacterVictoryPoints> getCharacterVictoryPointsTotal() {
		return characterVictoryPointsTotal;
	}

	public List<CorporationKills> getCorporationKillsYesterday() {
		return corporationKillsYesterday;
	}

	public List<CorporationKills> getCorporationKillsLastWeek() {
		return corporationKillsLastWeek;
	}

	public List<CorporationKills> getCorporationKillsTotal() {
		return corporationKillsTotal;
	}

	public List<CorporationVictoryPoints> getCorporationVictoryPointsYesterday() {
		return corporationVictoryPointsYesterday;
	}

	public List<CorporationVictoryPoints> getCorporationVictoryPointsLastWeek() {
		return corporationVictoryPointsLastWeek;
	}

	public List<CorporationVictoryPoints> getCorporationVictoryPointsTotal() {
		return corporationVictoryPointsTotal;
	}

	public List<FactionKills> getFactionKillsYesterday() {
		return factionKillsYesterday;
	}

	public List<FactionKills> getFactionKillsLastWeek() {
		return factionKillsLastWeek;
	}

	public List<FactionKills> getFactionKillsTotal() {
		return factionKillsTotal;
	}

	public List<FactionVictoryPoints> getFactionVictoryPointsYesterday() {
		return factionVictoryPointsYesterday;
	}

	public List<FactionVictoryPoints> getFactionVictoryPointsLastWeek() {
		return factionVictoryPointsLastWeek;
	}

	public List<FactionVictoryPoints> getFactionVictoryPointsTotal() {
		return factionVictoryPointsTotal;
	}
}