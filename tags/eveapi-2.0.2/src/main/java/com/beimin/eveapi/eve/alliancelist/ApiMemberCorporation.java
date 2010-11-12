package com.beimin.eveapi.eve.alliancelist;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ApiMemberCorporation {
	private long corporationID;// ="109788662"
	private String startDate;// ="2007-09-09 19:12:00"
	private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public long getCorporationID() {
		return corporationID;
	}

	public void setCorporationID(long corporationID) {
		this.corporationID = corporationID;
	}

	public Date getStartDateTime() throws ParseException {
		return sdf.parse(startDate);
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
}