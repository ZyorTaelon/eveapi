package com.beimin.eveapi.eve.factwar.stats;

public class ApiFactionStats {
	private int factionID;
	private String factionName;
	private int pilots;
	private int systemsControlled;
	private int killsYesterday;
	private int killsLastWeek;
	private int killsTotal;
	private int victoryPointsYesterday;
	private int victoryPointsLastWeek;
	private int victoryPointsTotal;

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

	public int getPilots() {
		return pilots;
	}

	public void setPilots(int pilots) {
		this.pilots = pilots;
	}

	public int getSystemsControlled() {
		return systemsControlled;
	}

	public void setSystemsControlled(int systemsControlled) {
		this.systemsControlled = systemsControlled;
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