package com.beimin.eveapi.character.skill.intraining;

import java.text.ParseException;
import java.util.Date;

import com.beimin.eveapi.ApiResponse;
import com.beimin.eveapi.utils.DateUtils;

public class SkillInTrainingResponse extends ApiResponse {
	private static final long serialVersionUID = 1L;
	private String currentTQTime;
	private Date currentTQDate;
	private String trainingEndTime;
	private Date trainingEndDate;
	private String trainingStartTime;
	private Date trainingStartDate;
	private int trainingTypeID;
	private int trainingStartSP;
	private int trainingDestinationSP;
	private int trainingToLevel;
	private boolean skillInTraining;

	public String getCurrentTQTime() {
		return currentTQTime;
	}

	public void setCurrentTQTime(String currentTQTime) throws ParseException {
		this.currentTQTime = currentTQTime;
		this.currentTQDate = DateUtils.parse(currentTQTime);
	}

	public Date getCurrentTQDate() {
		return currentTQDate;
	}

	public String getTrainingEndTime() throws ParseException {
		return trainingEndTime;
	}

	public void setTrainingEndTime(String trainingEndTime)
			throws ParseException {
		this.trainingEndTime = trainingEndTime;
		this.trainingEndDate = DateUtils.parse(trainingEndTime);
	}

	public Date getTrainingEndDate() {
		return trainingEndDate;
	}

	public String getTrainingStartTime() throws ParseException {
		return trainingStartTime;
	}

	public void setTrainingStartTime(String trainingStartTime)
			throws ParseException {
		this.trainingStartTime = trainingStartTime;
		this.trainingStartDate = DateUtils.parse(trainingStartTime);
	}

	public Date getTrainingStartDate() {
		return trainingStartDate;
	}

	public int getTrainingTypeID() {
		return trainingTypeID;
	}

	public void setTrainingTypeID(int trainingTypeID) {
		this.trainingTypeID = trainingTypeID;
	}

	public int getTrainingStartSP() {
		return trainingStartSP;
	}

	public void setTrainingStartSP(int trainingStartSP) {
		this.trainingStartSP = trainingStartSP;
	}

	public int getTrainingDestinationSP() {
		return trainingDestinationSP;
	}

	public void setTrainingDestinationSP(int trainingDestinationSP) {
		this.trainingDestinationSP = trainingDestinationSP;
	}

	public int getTrainingToLevel() {
		return trainingToLevel;
	}

	public void setTrainingToLevel(int trainingToLevel) {
		this.trainingToLevel = trainingToLevel;
	}

	public boolean isSkillInTraining() {
		return skillInTraining;
	}

	public void setSkillInTraining(boolean skillInTraining) {
		this.skillInTraining = skillInTraining;
	}
}
