package com.beimin.eveapi.eve.alliancelist;

import java.text.ParseException;
import java.util.Date;

import com.beimin.eveapi.utils.DateUtils;

public class ApiMemberCorporation {
	private long corporationID;
	private String startDate;

	public long getCorporationID() {
		return corporationID;
	}

	public void setCorporationID(long corporationID) {
		this.corporationID = corporationID;
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
}