package com.beimin.eveapi.response.shared;

import java.util.Date;

import com.beimin.eveapi.response.ApiResponse;

public class FacWarStatsResponse extends ApiResponse {
	private static final long serialVersionUID = 1L;
	private int factionID;
	private String factionName;
	private Date enlisted;
	private int currentRank;
	private int highestRank;
	private int killsYesterday;
	private int killsLastWeek;
	private int killsTotal;
	private int victoryPointsYesterday;
	private int victoryPointsLastWeek;
	private int victoryPointsTotal;
	private int pilots;

	public int getFactionID() {
		return factionID;
	}

	public void setFactionID(int factionID) {
		this.factionID = factionID;
	}

	public String getFactionName() {
		return factionName;
	}

	public void setFactionName(String factionName) {
		this.factionName = factionName;
	}

	public Date getEnlisted() {
		return enlisted;
	}

	public void setEnlisted(Date enlisted) {
		this.enlisted = enlisted;
	}

	public int getCurrentRank() {
		return currentRank;
	}

	public void setCurrentRank(int currentRank) {
		this.currentRank = currentRank;
	}

	public int getHighestRank() {
		return highestRank;
	}

	public void setHighestRank(int highestRank) {
		this.highestRank = highestRank;
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

	public int getPilots() {
		return pilots;
	}

	public void setPilots(int pilots) {
		this.pilots = pilots;
	}
}