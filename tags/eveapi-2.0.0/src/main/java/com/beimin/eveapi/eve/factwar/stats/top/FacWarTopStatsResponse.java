package com.beimin.eveapi.eve.factwar.stats.top;

import com.beimin.eveapi.ApiResponse;

public class FacWarTopStatsResponse extends ApiResponse {
	private CharacterStats characterStats;
	private CorporationStats corporationStats;
	private FactionStats factionStats;
	
	public CharacterStats getCharacterStats() {
		return characterStats;
	}

	public void setCharacterStats(CharacterStats characterStats) {
		this.characterStats = characterStats;
	}

	public CorporationStats getCorporationStats() {
		return corporationStats;
	}

	public void setCorporationStats(CorporationStats corporationStats) {
		this.corporationStats = corporationStats;
	}

	public FactionStats getFactionStats() {
		return factionStats;
	}

	public void setFactionStats(FactionStats factionStats) {
		this.factionStats = factionStats;
	}
}