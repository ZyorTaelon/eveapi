package com.beimin.eveapi.eve.alliancelist;

import java.util.Date;

public class ApiMemberCorporation {
	private long corporationID;
	private Date startDate;

	public long getCorporationID() {
		return corporationID;
	}

	public void setCorporationID(long corporationID) {
		this.corporationID = corporationID;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
}