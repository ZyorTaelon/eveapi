package com.beimin.eveapi.character.skill.queue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ApiSkillQueueItem {
	private int queuePosition;
	private int typeID;
	private int level;
	private int startSP;
	private int endSP;
	private String startTime;
	private String endTime;
	private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

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
		return sdf.parse(startTime);
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public Date getEndDate() throws ParseException {
		return sdf.parse(endTime);
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
}