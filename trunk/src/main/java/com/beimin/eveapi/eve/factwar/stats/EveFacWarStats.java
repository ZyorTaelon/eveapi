package com.beimin.eveapi.eve.factwar.stats;

import java.util.ArrayList;
import java.util.List;

import com.beimin.eveapi.core.ApiResponse;

public class EveFacWarStats extends ApiResponse {
	private static final long serialVersionUID = 1L;
	private final List<ApiFactionStats> factions = new ArrayList<ApiFactionStats>();
	private final List<ApiFactionWar> wars = new ArrayList<ApiFactionWar>();
	private int killsYesterday;
	private int killsLastWeek;
	private int killsTotal;
	private int victoryPointsYesterday;
	private int victoryPointsLastWeek;
	private int victoryPointsTotal;

	public void addStat(ApiFactionStats factionStats) {
		this.factions.add(factionStats);
	}

	public void addStat(ApiFactionWar factionWar) {
		wars.add(factionWar);
	}

	public List<ApiFactionStats> getFactions() {
		return factions;
	}

	public List<ApiFactionWar> getWars() {
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