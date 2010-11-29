package com.beimin.eveapi.eve.factwar.stats.top;

public class CorporationVictoryPoints extends CorporationStat implements VictoryPointsStat {
	private int victoryPoints;

	@Override
	public int getVictoryPoints() {
		return victoryPoints;
	}

	public void setVictoryPoints(int victoryPoints) {
		this.victoryPoints = victoryPoints;
	}
}