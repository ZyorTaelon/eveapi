package com.beimin.eveapi.model.eve;

import java.util.Date;

public class MemberCorporation {
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