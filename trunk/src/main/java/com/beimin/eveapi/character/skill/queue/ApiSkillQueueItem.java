package com.beimin.eveapi.character.skill.queue;

import java.text.ParseException;
import java.util.Date;

import com.beimin.eveapi.utils.DateUtils;

public class ApiSkillQueueItem {
	private int queuePosition;
	private int typeID;
	private int level;
	private int startSP;
	private int endSP;
	private String startTime;
	private String endTime;

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

	public Date getStartDate() throws ParseException {
		return DateUtils.parse(startTime);
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public Date getEndDate() throws ParseException {
		return DateUtils.parse(endTime);
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
}