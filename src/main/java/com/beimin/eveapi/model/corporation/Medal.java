package com.beimin.eveapi.model.corporation;

import java.util.Date;

import com.beimin.eveapi.model.shared.AbstractMedal;

public class Medal extends AbstractMedal {
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