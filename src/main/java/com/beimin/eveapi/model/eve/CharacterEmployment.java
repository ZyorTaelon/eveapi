package com.beimin.eveapi.model.eve;

import java.util.Date;

public class CharacterEmployment {
	private Long corporationID;
	private Date startDate;

	public Long getCorporationID() {
		return corporationID;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setCorporationID(Long id) {
		corporationID = id;
	}

	public void setStartDate(Date date) {
		startDate = date;
	}

}