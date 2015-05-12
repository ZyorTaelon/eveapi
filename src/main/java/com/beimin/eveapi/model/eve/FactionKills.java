package com.beimin.eveapi.model.eve;

public class FactionKills extends FactionStat implements KillStat {
	private int kills;

	public int getKills() {
		return kills;
	}

	public void setKills(int kills) {
		this.kills = kills;
	}
}