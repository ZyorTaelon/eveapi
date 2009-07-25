package com.beimin.eveapi.character.training;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.beimin.eveapi.ApiResponse;

public class Response extends ApiResponse {
	private String trainingEndTime;
	private String trainingStartTime;
	private int trainingTypeID;
	private int trainingStartSP;
	private int trainingDestinationSP;
	private int trainingToLevel;
	private boolean skillInTraining;
	private final SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");

	public String getTrainingEndTime() throws ParseException {
		return trainingEndTime;
	}

	public Date getTrainingEndDate() throws ParseException {
		return sdf.parse(trainingEndTime);
	}

	public void setTrainingEndTime(String trainingEndTime) {
		this.trainingEndTime = trainingEndTime;
	}

	public String getTrainingStartTime() throws ParseException {
		return trainingStartTime;
	}

	public Date getTrainingStartDate() throws ParseException {
		return sdf.parse(trainingStartTime);
	}

	public void setTrainingStartTime(String trainingStartTime) {
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
