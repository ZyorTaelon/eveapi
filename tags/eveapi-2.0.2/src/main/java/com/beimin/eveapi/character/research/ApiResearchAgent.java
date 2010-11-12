package com.beimin.eveapi.character.research;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ApiResearchAgent {
	private int agentID;
	private int skillTypeID;
	private String researchStartDate;
	private double pointsPerDay;
	private double remainderPoints;
	private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

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

	public Date getResearchStartDateTime() throws ParseException {
		return sdf.parse(researchStartDate);
	}

	public String getResearchStartDate() {
		return researchStartDate;
	}

	public void setResearchStartDate(String researchStartDate) {
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
		try {
			long startDate = getResearchStartDateTime().getTime();
			long now = Calendar.getInstance().getTime().getTime();
			long elapse = now - startDate;
			double daysSinceStart = elapse / (1000.0 * 60 * 60 * 24);
			return remainderPoints + (pointsPerDay * daysSinceStart);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return remainderPoints;
	}
}