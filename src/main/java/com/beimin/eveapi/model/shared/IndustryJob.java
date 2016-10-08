package com.beimin.eveapi.model.shared;

import java.util.Date;

public class IndustryJob {
    private long jobID;
    private long installerID; // OwnerID : int
    private String installerName;
    private long facilityID;
    private long solarSystemID; // LocationID : long
    private String solarSystemName;
    private long stationID;
    private int activityID;
    private long blueprintID;
    private int blueprintTypeID;
    private String blueprintTypeName;
    private long blueprintLocationID;
    private long outputLocationID;
    private int runs;
    private double cost;
    private long teamID;
    private int licensedRuns;
    private double probability;
    private int productTypeID;
    private String productTypeName;
    private int status;
    private int timeInSeconds;
    private Date completedDate;
    private Date startDate;
    private Date endDate;
    private Date pauseDate;
    private long completedCharacterID;

    public long getJobID() {
        return jobID;
    }

    public void setJobID(final long jobID) {
        this.jobID = jobID;
    }

    public long getInstallerID() {
        return installerID;
    }

    public void setInstallerID(final long installerID) {
        this.installerID = installerID;
    }

    public String getInstallerName() {
        return installerName;
    }

    public void setInstallerName(final String installerName) {
        this.installerName = installerName;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(final int runs) {
        this.runs = runs;
    }

    public long getSolarSystemID() {
        return solarSystemID;
    }

    public void setSolarSystemID(final long solarSystemID) {
        this.solarSystemID = solarSystemID;
    }

    public int getActivityID() {
        return activityID;
    }

    public void setActivityID(final int activityID) {
        this.activityID = activityID;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(final Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(final Date endDate) {
        this.endDate = endDate;
    }

    public long getFacilityID() {
        return facilityID;
    }

    public void setFacilityID(final long facilityID) {
        this.facilityID = facilityID;
    }

    public String getSolarSystemName() {
        return solarSystemName;
    }

    public void setSolarSystemName(final String solarSystemName) {
        this.solarSystemName = solarSystemName;
    }

    public long getStationID() {
        return stationID;
    }

    public void setStationID(final long stationID) {
        this.stationID = stationID;
    }

    public long getBlueprintID() {
        return blueprintID;
    }

    public void setBlueprintID(final long blueprintID) {
        this.blueprintID = blueprintID;
    }

    public int getBlueprintTypeID() {
        return blueprintTypeID;
    }

    public void setBlueprintTypeID(final int blueprintTypeID) {
        this.blueprintTypeID = blueprintTypeID;
    }

    public String getBlueprintTypeName() {
        return blueprintTypeName;
    }

    public void setBlueprintTypeName(final String blueprintTypeName) {
        this.blueprintTypeName = blueprintTypeName;
    }

    public long getBlueprintLocationID() {
        return blueprintLocationID;
    }

    public void setBlueprintLocationID(final long blueprintLocationID) {
        this.blueprintLocationID = blueprintLocationID;
    }

    public long getOutputLocationID() {
        return outputLocationID;
    }

    public void setOutputLocationID(final long outputLocationID) {
        this.outputLocationID = outputLocationID;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(final double cost) {
        this.cost = cost;
    }

    public long getTeamID() {
        return teamID;
    }

    public void setTeamID(final long teamID) {
        this.teamID = teamID;
    }

    public int getLicensedRuns() {
        return licensedRuns;
    }

    public void setLicensedRuns(final int licensedRuns) {
        this.licensedRuns = licensedRuns;
    }

    public double getProbability() {
        return probability;
    }

    public void setProbability(final double probability) {
        this.probability = probability;
    }

    public int getProductTypeID() {
        return productTypeID;
    }

    public void setProductTypeID(final int productTypeID) {
        this.productTypeID = productTypeID;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(final String productTypeName) {
        this.productTypeName = productTypeName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(final int status) {
        this.status = status;
    }

    public int getTimeInSeconds() {
        return timeInSeconds;
    }

    public void setTimeInSeconds(final int timeInSeconds) {
        this.timeInSeconds = timeInSeconds;
    }

    public Date getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(final Date completedDate) {
        this.completedDate = completedDate;
    }

    public Date getPauseDate() {
        return pauseDate;
    }

    public void setPauseDate(final Date pauseDate) {
        this.pauseDate = pauseDate;
    }

    public long getCompletedCharacterID() {
        return completedCharacterID;
    }

    public void setCompletedCharacterID(final long completedCharacterID) {
        this.completedCharacterID = completedCharacterID;
    }
}
