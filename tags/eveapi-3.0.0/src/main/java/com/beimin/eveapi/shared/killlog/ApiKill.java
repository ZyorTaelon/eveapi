package com.beimin.eveapi.shared.killlog;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApiKill {
	private long killID;
	private long solarSystemID;
	private Date killTime;
	private Integer moonID;
	private ApiKillVictim victim;
	private final List<ApiKillAttacker> attackers = new ArrayList<ApiKillAttacker>();
	private final List<ApiKillItem> items = new ArrayList<ApiKillItem>();

	public long getKillID() {
		return killID;
	}

	public void setKillID(long killID) {
		this.killID = killID;
	}

	public long getSolarSystemID() {
		return solarSystemID;
	}

	public void setSolarSystemID(long solarSystemID) {
		this.solarSystemID = solarSystemID;
	}

	public Date getKillTime() {
		return killTime;
	}

	public void setKillTime(Date killTime) {
		this.killTime = killTime;
	}

	public Integer getMoonID() {
		return moonID;
	}

	public void setMoonID(Integer moonID) {
		this.moonID = moonID;
	}

	public ApiKillVictim getVictim() {
		return victim;
	}

	public void setVictim(ApiKillVictim victim) {
		this.victim = victim;
	}

	public void addKillDetail(ApiKillAttacker attacker) {
		attackers.add(attacker);
	}

	public List<ApiKillAttacker> getAttackers() {
		return attackers;
	}

	public void addKillDetail(ApiKillItem item) {
		items.add(item);
	}

	public List<ApiKillItem> getItems() {
		return items;
	}
}