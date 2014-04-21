package com.beimin.eveapi.model.eve;

public class FactionVictoryPoints extends FactionStat implements VictoryPointsStat {
	private int victoryPoints;

	public int getVictoryPoints() {
		return victoryPoints;
	}

	public void setVictoryPoints(int victoryPoints) {
		this.victoryPoints = victoryPoints;
	}
}