package com.beimin.eveapi.character.skill.intraining;

import java.text.ParseException;
import java.util.Date;

import com.beimin.eveapi.ApiResponse;

public class SkillInTrainingResponse extends ApiResponse {
	private static final long serialVersionUID = 1L;
	private Date currentTQTime;
	private Date trainingEndTime;
	private Date trainingStartTime;
	private int trainingTypeID;
	private int trainingStartSP;
	private int trainingDestinationSP;
	private int trainingToLevel;
	private boolean skillInTraining;

	public Date getCurrentTQTime() {
		return currentTQTime;
	}

	public void setCurrentTQTime(Date currentTQTime) throws ParseException {
		this.currentTQTime = currentTQTime;
	}

	public Date getTrainingEndTime() throws ParseException {
		return trainingEndTime;
	}

	public void setTrainingEndTime(Date trainingEndTime) throws ParseException {
		this.trainingEndTime = trainingEndTime;
	}

	public Date getTrainingStartTime() {
		return trainingStartTime;
	}

	public void setTrainingStartTime(Date trainingStartTime) throws ParseException {
		this.trainingStartTime = trainingStartTime;
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
