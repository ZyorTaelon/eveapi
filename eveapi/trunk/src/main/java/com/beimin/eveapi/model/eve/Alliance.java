package com.beimin.eveapi.model.eve;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class Alliance {
	private String name;
	private String shortName;
	private long allianceID;
	private long executorCorpID;
	private int memberCount;
	private Date startDate;
	private final Collection<MemberCorporation> memberCorporations = new ArrayList<MemberCorporation>();

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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void add(MemberCorporation memberCorporation) {
		memberCorporations.add(memberCorporation);
	}

	public Collection<MemberCorporation> getMemberCorporations() {
		return memberCorporations;
	}
}