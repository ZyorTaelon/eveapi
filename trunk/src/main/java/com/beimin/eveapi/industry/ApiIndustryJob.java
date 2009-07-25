package com.beimin.eveapi.industry;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ApiIndustryJob {
	private long jobID;
	private long containerID;
	private long installedItemID;
	private long installedItemLocationID;
	private int installedItemQuantity;
	private int installedItemProductivityLevel;
	private int installedItemMaterialLevel;
	private int installedItemLicensedProductionRunsRemaining;
	private long outputLocationID;
	private long installerID;
	private int runs;
	private int licensedProductionRuns;
	private long installedInSolarSystemID;
	private long containerLocationID;
	private int materialMultiplier;
	private int charMaterialMultiplier;
	private int timeMultiplier;
	private int charTimeMultiplier;
	private long installedItemTypeID;
	private long outputTypeID;
	private long containerTypeID;
	private long installedItemCopy;
	private int completed;
	private int completedSuccessfully;
	private int installedItemFlag;
	private int outputFlag;
	private int activityID;
	private int completedStatus;
	private String installTime;
	private String beginProductionTime;
	private String endProductionTime;
	private String pauseProductionTime;
	private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public long getJobID() {
		return jobID;
	}

	public void setJobID(long jobID) {
		this.jobID = jobID;
	}

	public long getContainerID() {
		return containerID;
	}

	public void setContainerID(long containerID) {
		this.containerID = containerID;
	}

	public long getInstalledItemID() {
		return installedItemID;
	}

	public void setInstalledItemID(long installedItemID) {
		this.installedItemID = installedItemID;
	}

	public long getInstalledItemLocationID() {
		return installedItemLocationID;
	}

	public void setInstalledItemLocationID(long installedItemLocationID) {
		this.installedItemLocationID = installedItemLocationID;
	}

	public int getInstalledItemQuantity() {
		return installedItemQuantity;
	}

	public void setInstalledItemQuantity(int installedItemQuantity) {
		this.installedItemQuantity = installedItemQuantity;
	}

	public int getInstalledItemProductivityLevel() {
		return installedItemProductivityLevel;
	}

	public void setInstalledItemProductivityLevel(int installedItemProductivityLevel) {
		this.installedItemProductivityLevel = installedItemProductivityLevel;
	}

	public int getInstalledItemMaterialLevel() {
		return installedItemMaterialLevel;
	}

	public void setInstalledItemMaterialLevel(int installedItemMaterialLevel) {
		this.installedItemMaterialLevel = installedItemMaterialLevel;
	}

	public int getInstalledItemLicensedProductionRunsRemaining() {
		return installedItemLicensedProductionRunsRemaining;
	}

	public void setInstalledItemLicensedProductionRunsRemaining(int installedItemLicensedProductionRunsRemaining) {
		this.installedItemLicensedProductionRunsRemaining = installedItemLicensedProductionRunsRemaining;
	}

	public long getOutputLocationID() {
		return outputLocationID;
	}

	public void setOutputLocationID(long outputLocationID) {
		this.outputLocationID = outputLocationID;
	}

	public long getInstallerID() {
		return installerID;
	}

	public void setInstallerID(long installerID) {
		this.installerID = installerID;
	}

	public int getRuns() {
		return runs;
	}

	public void setRuns(int runs) {
		this.runs = runs;
	}

	public int getLicensedProductionRuns() {
		return licensedProductionRuns;
	}

	public void setLicensedProductionRuns(int licensedProductionRuns) {
		this.licensedProductionRuns = licensedProductionRuns;
	}

	public long getInstalledInSolarSystemID() {
		return installedInSolarSystemID;
	}

	public void setInstalledInSolarSystemID(long installedInSolarSystemID) {
		this.installedInSolarSystemID = installedInSolarSystemID;
	}

	public long getContainerLocationID() {
		return containerLocationID;
	}

	public void setContainerLocationID(long containerLocationID) {
		this.containerLocationID = containerLocationID;
	}

	public int getMaterialMultiplier() {
		return materialMultiplier;
	}

	public void setMaterialMultiplier(int materialMultiplier) {
		this.materialMultiplier = materialMultiplier;
	}

	public int getCharMaterialMultiplier() {
		return charMaterialMultiplier;
	}

	public void setCharMaterialMultiplier(int charMaterialMultiplier) {
		this.charMaterialMultiplier = charMaterialMultiplier;
	}

	public int getTimeMultiplier() {
		return timeMultiplier;
	}

	public void setTimeMultiplier(int timeMultiplier) {
		this.timeMultiplier = timeMultiplier;
	}

	public int getCharTimeMultiplier() {
		return charTimeMultiplier;
	}

	public void setCharTimeMultiplier(int charTimeMultiplier) {
		this.charTimeMultiplier = charTimeMultiplier;
	}

	public long getInstalledItemTypeID() {
		return installedItemTypeID;
	}

	public void setInstalledItemTypeID(long installedItemTypeID) {
		this.installedItemTypeID = installedItemTypeID;
	}

	public long getOutputTypeID() {
		return outputTypeID;
	}

	public void setOutputTypeID(long outputTypeID) {
		this.outputTypeID = outputTypeID;
	}

	public long getContainerTypeID() {
		return containerTypeID;
	}

	public void setContainerTypeID(long containerTypeID) {
		this.containerTypeID = containerTypeID;
	}

	public long getInstalledItemCopy() {
		return installedItemCopy;
	}

	public void setInstalledItemCopy(long installedItemCopy) {
		this.installedItemCopy = installedItemCopy;
	}

	public int getCompleted() {
		return completed;
	}

	public void setCompleted(int completed) {
		this.completed = completed;
	}

	public int getCompletedSuccessfully() {
		return completedSuccessfully;
	}

	public void setCompletedSuccessfully(int completedSuccessfully) {
		this.completedSuccessfully = completedSuccessfully;
	}

	public int getInstalledItemFlag() {
		return installedItemFlag;
	}

	public void setInstalledItemFlag(int installedItemFlag) {
		this.installedItemFlag = installedItemFlag;
	}

	public int getOutputFlag() {
		return outputFlag;
	}

	public void setOutputFlag(int outputFlag) {
		this.outputFlag = outputFlag;
	}

	public int getActivityID() {
		return activityID;
	}

	public void setActivityID(int activityID) {
		this.activityID = activityID;
	}

	public int getCompletedStatus() {
		return completedStatus;
	}

	public void setCompletedStatus(int completedStatus) {
		this.completedStatus = completedStatus;
	}

	public Date getInstallTimeDate() throws ParseException {
		return sdf.parse(installTime);
	}

	public String getInstallTime() {
		return installTime;
	}

	public void setInstallTime(String installTime) {
		this.installTime = installTime;
	}

	public Date getBeginProductionTimeDate() throws ParseException {
		return sdf.parse(beginProductionTime);
	}

	public String getBeginProductionTime() {
		return beginProductionTime;
	}

	public void setBeginProductionTime(String beginProductionTime) {
		this.beginProductionTime = beginProductionTime;
	}

	public Date getEndProductionTimeDate() throws ParseException {
		return sdf.parse(endProductionTime);
	}

	public String getEndProductionTime() {
		return endProductionTime;
	}

	public void setEndProductionTime(String endProductionTime) {
		this.endProductionTime = endProductionTime;
	}

	public Date getPauseProductionTimeDate() throws ParseException {
		return sdf.parse(pauseProductionTime);
	}

	public String getPauseProductionTime() {
		return pauseProductionTime;
	}

	public void setPauseProductionTime(String pauseProductionTime) {
		this.pauseProductionTime = pauseProductionTime;
	}
}