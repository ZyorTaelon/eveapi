package com.beimin.eveapi.model.shared;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Kill {
	private long killID;
	private long solarSystemID;
	private Date killTime;
	private Integer moonID;
	private KillVictim victim;
	private final List<KillAttacker> attackers = new ArrayList<KillAttacker>();
	private final List<KillItem> items = new ArrayList<KillItem>();

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

	public KillVictim getVictim() {
		return victim;
	}

	public void setVictim(KillVictim victim) {
		this.victim = victim;
	}

	public void add(KillAttacker attacker) {
		attackers.add(attacker);
	}

	public List<KillAttacker> getAttackers() {
		return attackers;
	}

	public void add(KillItem item) {
		items.add(item);
	}

	public List<KillItem> getItems() {
		return items;
	}
}