package com.beimin.eveapi.model.pilot;

import java.util.Date;

public class SkillQueueItem {
	private int queuePosition;
	private int typeID;
	private int level;
	private int startSP;
	private int endSP;
	private Date startTime;
	private Date endTime;

	public int getQueuePosition() {
		return queuePosition;
	}

	public void setQueuePosition(int queuePosition) {
		this.queuePosition = queuePosition;
	}

	public int getTypeID() {
		return typeID;
	}

	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getStartSP() {
		return startSP;
	}

	public void setStartSP(int startSP) {
		this.startSP = startSP;
	}

	public int getEndSP() {
		return endSP;
	}

	public void setEndSP(int endSP) {
		this.endSP = endSP;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
}