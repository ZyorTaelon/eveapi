package com.beimin.eveapi.eve.factwar.stats.top;

public class CorporationKills extends CorporationStat implements KillStat {
	private int kills;

	public int getKills() {
		return kills;
	}

	public void setKills(int kills) {
		this.kills = kills;
	}
}