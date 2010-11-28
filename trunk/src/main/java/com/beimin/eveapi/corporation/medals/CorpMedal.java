package com.beimin.eveapi.corporation.medals;

import java.text.ParseException;
import java.util.Date;

import com.beimin.eveapi.shared.medals.Medal;
import com.beimin.eveapi.utils.DateUtils;

public class CorpMedal extends Medal {
	private long creatorID;
	private String created;

	public long getCreatorID() {
		return creatorID;
	}

	public void setCreatorID(long creatorID) {
		this.creatorID = creatorID;
	}

	public Date getCreatedDateTime() throws ParseException {
		return DateUtils.parse(created);
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}
}