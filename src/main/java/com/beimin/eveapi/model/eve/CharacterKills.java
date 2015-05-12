package com.beimin.eveapi.model.eve;

public class CharacterKills extends CharacterStat implements KillStat {
	private int kills;

	public int getKills() {
		return kills;
	}

	public void setKills(int kills) {
		this.kills = kills;
	}
}