package com.beimin.eveapi.eve.factwar.stats.top;

public class CharacterKills extends CharacterStat implements KillStat {
	private int kills;

	@Override
	public int getKills() {
		return kills;
	}

	public void setKills(int kills) {
		this.kills = kills;
	}
}