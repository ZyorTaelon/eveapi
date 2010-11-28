package com.beimin.eveapi.corporation.medals;

import java.util.Date;

import com.beimin.eveapi.shared.medals.Medal;

public class CorpMedal extends Medal {
	private long creatorID;
	private Date created;

	public long getCreatorID() {
		return creatorID;
	}

	public void setCreatorID(long creatorID) {
		this.creatorID = creatorID;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
}