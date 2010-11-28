package com.beimin.eveapi.eve.alliancelist;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import com.beimin.eveapi.utils.DateUtils;

public class ApiAlliance {
	private String name;// ="GoonSwarm"
	private String shortName;// ="OHGOD"
	private long allianceID;// ="824518128"
	private long executorCorpID;// ="749147334"
	private int memberCount;// ="5925"
	private String startDate;// ="2006-06-03 00:50:00"
	private final Collection<ApiMemberCorporation> memberCorporations = new ArrayList<ApiMemberCorporation>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public long getAllianceID() {
		return allianceID;
	}

	public void setAllianceID(long allianceID) {
		this.allianceID = allianceID;
	}

	public long getExecutorCorpID() {
		return executorCorpID;
	}

	public void setExecutorCorpID(long executorCorpID) {
		this.executorCorpID = executorCorpID;
	}

	public int getMemberCount() {
		return memberCount;
	}

	public void setMemberCount(int memberCount) {
		this.memberCount = memberCount;
	}

	public Date getStartDateTime() throws ParseException {
		return DateUtils.parse(startDate);
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public void addMemberCorporation(ApiMemberCorporation memberCorporation) {
		memberCorporations.add(memberCorporation);
	}

	public Collection<ApiMemberCorporation> getMemberCorporations() {
		return memberCorporations;
	}
}