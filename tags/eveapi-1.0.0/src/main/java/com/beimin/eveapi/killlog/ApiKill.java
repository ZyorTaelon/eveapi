package com.beimin.eveapi.killlog;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApiKill {
	private long killID; // ="4879947"
	private long solarSystemID;// ="30002058"
	private String killTime;// ="2008-12-18 23:57:00"
	private Integer moonID;// ="0"
	private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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