package com.beimin.eveapi.model.pilot;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class ResearchAgent {
	private int agentID;
	private int skillTypeID;
	private Date researchStartDate;
	private double pointsPerDay;
	private double remainderPoints;

	public int getAgentID() {
		return agentID;
	}

	public void setAgentID(int agentID) {
		this.agentID = agentID;
	}

	public int getSkillTypeID() {
		return skillTypeID;
	}

	public void setSkillTypeID(int skillTypeID) {
		this.skillTypeID = skillTypeID;
	}

	public Date getResearchStartDate() {
		return researchStartDate;
	}

	public void setResearchStartDate(Date researchStartDate) {
		this.researchStartDate = researchStartDate;
	}

	public double getPointsPerDay() {
		return pointsPerDay;
	}

	public void setPointsPerDay(double pointsPerDay) {
		this.pointsPerDay = pointsPerDay;
	}

	public double getRemainderPoints() {
		return remainderPoints;
	}

	public void setRemainderPoints(double remainderPoints) {
		this.remainderPoints = remainderPoints;
	}

	public double getCurrentPoints() {
		long startDate = researchStartDate.getTime();
		long now = Calendar.getInstance(TimeZone.getTimeZone("GMT")).getTimeInMillis();
		long elapse = now - startDate;
		double daysSinceStart = elapse / (1000.0 * 60 * 60 * 24);
		return remainderPoints + (pointsPerDay * daysSinceStart);
	}
}