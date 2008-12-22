package com.beimin.eveapi.killlog;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Kill {
	private long killID; // ="4879947"
	private long solarSystemID;// ="30002058"
	private String killTime;// ="2008-12-18 23:57:00"
	private Integer moonID;// ="0"
	private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private Victim victim;
	private final List<Attacker> attackers = new ArrayList<Attacker>();
	private final List<Item> items = new ArrayList<Item>();

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

	public Date getKillDateTime() throws ParseException {
		return sdf.parse(killTime);
	}

	public String getKillTime() {
		return killTime;
	}

	public void setKillTime(String killTime) {
		this.killTime = killTime;
	}

	public Integer getMoonID() {
		return moonID;
	}

	public void setMoonID(Integer moonID) {
		this.moonID = moonID;
	}

	public Victim getVictim() {
		return victim;
	}

	public void setVictim(Victim victim) {
		this.victim = victim;
	}

	public void addKillDetail(Attacker attacker) {
		attackers.add(attacker);
	}

	public List<Attacker> getAttackers() {
		return attackers;
	}

	public void addKillDetail(Item item) {
		items.add(item);
	}

	public List<Item> getItems() {
		return items;
	}
}