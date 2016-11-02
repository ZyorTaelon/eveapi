package com.beimin.eveapi.response.character;

import java.util.Date;

import com.beimin.eveapi.response.ApiResponse;

public class SkillInTrainingResponse extends ApiResponse {
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

    public void setCurrentTQTime(final Date currentTQTime) {
        this.currentTQTime = currentTQTime;
    }

    public Date getTrainingEndTime() {
        return trainingEndTime;
    }

    public void setTrainingEndTime(final Date trainingEndTime) {
        this.trainingEndTime = trainingEndTime;
    }

    public Date getTrainingStartTime() {
        return trainingStartTime;
    }

    public void setTrainingStartTime(final Date trainingStartTime) {
        this.trainingStartTime = trainingStartTime;
    }

    public int getTrainingTypeID() {
        return trainingTypeID;
    }

    public void setTrainingTypeID(final int trainingTypeID) {
        this.trainingTypeID = trainingTypeID;
    }

    public int getTrainingStartSP() {
        return trainingStartSP;
    }

    public void setTrainingStartSP(final int trainingStartSP) {
        this.trainingStartSP = trainingStartSP;
    }

    public int getTrainingDestinationSP() {
        return trainingDestinationSP;
    }

    public void setTrainingDestinationSP(final int trainingDestinationSP) {
        this.trainingDestinationSP = trainingDestinationSP;
    }

    public int getTrainingToLevel() {
        return trainingToLevel;
    }

    public void setTrainingToLevel(final int trainingToLevel) {
        this.trainingToLevel = trainingToLevel;
    }

    public boolean isSkillInTraining() {
        return skillInTraining;
    }

    public void setSkillInTraining(final boolean skillInTraining) {
        this.skillInTraining = skillInTraining;
    }
}
