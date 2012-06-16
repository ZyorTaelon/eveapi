package com.beimin.eveapi.eve.factwar.stats.top;

public class CharacterVictoryPoints extends CharacterStat implements VictoryPointsStat {
	private int victoryPoints;

	public int getVictoryPoints() {
		return victoryPoints;
	}

	public void setVictoryPoints(int victoryPoints) {
		this.victoryPoints = victoryPoints;
	}
}