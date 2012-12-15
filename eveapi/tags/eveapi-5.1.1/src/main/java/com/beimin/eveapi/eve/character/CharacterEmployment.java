package com.beimin.eveapi.eve.character;

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

	void setCorporationID(Long id) {
		corporationID = id;
	}

	void setStartDate(Date date) {
		startDate = date;
	}

}