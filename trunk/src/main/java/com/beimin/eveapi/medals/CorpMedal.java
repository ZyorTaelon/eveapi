package com.beimin.eveapi.medals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CorpMedal extends Medal {
	private long creatorID;
	private String created;
	private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public long getCreatorID() {
		return creatorID;
	}

	public void setCreatorID(long creatorID) {
		this.creatorID = creatorID;
	}

	public Date getCreatedDateTime() throws ParseException {
		return sdf.parse(created);
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}
}