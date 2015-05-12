package com.beimin.eveapi.model.eve;

public class CorporationVictoryPoints extends CorporationStat implements VictoryPointsStat {
	private int victoryPoints;

	public int getVictoryPoints() {
		return victoryPoints;
	}

	public void setVictoryPoints(int victoryPoints) {
		this.victoryPoints = victoryPoints;
	}
}