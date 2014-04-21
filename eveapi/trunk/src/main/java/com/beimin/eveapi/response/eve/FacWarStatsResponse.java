package com.beimin.eveapi.response.eve;

import java.util.ArrayList;
import java.util.List;

import com.beimin.eveapi.model.eve.FactionStats;
import com.beimin.eveapi.model.eve.FactionWar;
import com.beimin.eveapi.response.ApiResponse;

public class FacWarStatsResponse extends ApiResponse {
	private static final long serialVersionUID = 1L;
	private final List<FactionStats> factions = new ArrayList<FactionStats>();
	private final List<FactionWar> wars = new ArrayList<FactionWar>();
	private int killsYesterday;
	private int killsLastWeek;
	private int killsTotal;
	private int victoryPointsYesterday;
	private int victoryPointsLastWeek;
	private int victoryPointsTotal;

	public void addStat(FactionStats factionStats) {
		this.factions.add(factionStats);
	}

	public void addStat(FactionWar factionWar) {
		wars.add(factionWar);
	}

	public List<FactionStats> getFactions() {
		return factions;
	}

	public List<FactionWar> getWars() {
		return wars;
	}

	public int getKillsYesterday() {
		return killsYesterday;
	}

	public void setKillsYesterday(int killsYesterday) {
		this.killsYesterday = killsYesterday;
	}

	public int getKillsLastWeek() {
		return killsLastWeek;
	}

	public void setKillsLastWeek(int killsLastWeek) {
		this.killsLastWeek = killsLastWeek;
	}

	public int getKillsTotal() {
		return killsTotal;
	}

	public void setKillsTotal(int killsTotal) {
		this.killsTotal = killsTotal;
	}

	public int getVictoryPointsYesterday() {
		return victoryPointsYesterday;
	}

	public void setVictoryPointsYesterday(int victoryPointsYesterday) {
		this.victoryPointsYesterday = victoryPointsYesterday;
	}

	public int getVictoryPointsLastWeek() {
		return victoryPointsLastWeek;
	}

	public void setVictoryPointsLastWeek(int victoryPointsLastWeek) {
		this.victoryPointsLastWeek = victoryPointsLastWeek;
	}

	public int getVictoryPointsTotal() {
		return victoryPointsTotal;
	}

	public void setVictoryPointsTotal(int victoryPointsTotal) {
		this.victoryPointsTotal = victoryPointsTotal;
	}
}