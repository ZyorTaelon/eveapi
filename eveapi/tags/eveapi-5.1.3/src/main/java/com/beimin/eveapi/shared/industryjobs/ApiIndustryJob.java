package com.beimin.eveapi.shared.industryjobs;

import java.util.Date;

public class ApiIndustryJob {
	private long jobID;
	private long assemblyLineID;
	private long containerID; // LocationID or ItemID : long
	private long installedItemID; // ItemID : long
	private long installedItemLocationID; // LocationID : long
	private int installedItemQuantity;
	private int installedItemProductivityLevel;
	private int installedItemMaterialLevel;
	private int installedItemLicensedProductionRunsRemaining;
	private long outputLocationID; // LocationID : long
	private long installerID; // OwnerID : int
	private int runs;
	private int licensedProductionRuns;
	private long installedInSolarSystemID; // LocationID : long
	private long containerLocationID; // LocationID : long
	private double materialMultiplier;
	private double charMaterialMultiplier;
	private double timeMultiplier;
	private double charTimeMultiplier;
	private int installedItemTypeID; // TypeID : int
	private int outputTypeID; // TypeID : int
	private int containerTypeID; // TypeID : int
	private long installedItemCopy;
	private boolean completed;
	private boolean completedSuccessfully;
	private int installedItemFlag;
	private int outputFlag;
	private int activityID;
	private int completedStatus;
	private Date installTime;
	private Date beginProductionTime;
	private Date endProductionTime;
	private Date pauseProductionTime;

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

	public long getAssemblyLineID() {
		return assemblyLineID;
	}

	public void setAssemblyLineID(long assemblyLineID) {
		this.assemblyLineID = assemblyLineID;
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

	public double getMaterialMultiplier() {
		return materialMultiplier;
	}

	public void setMaterialMultiplier(double materialMultiplier) {
		this.materialMultiplier = materialMultiplier;
	}

	public double getCharMaterialMultiplier() {
		return charMaterialMultiplier;
	}

	public void setCharMaterialMultiplier(double charMaterialMultiplier) {
		this.charMaterialMultiplier = charMaterialMultiplier;
	}

	public double getTimeMultiplier() {
		return timeMultiplier;
	}

	public void setTimeMultiplier(double timeMultiplier) {
		this.timeMultiplier = timeMultiplier;
	}

	public double getCharTimeMultiplier() {
		return charTimeMultiplier;
	}

	public void setCharTimeMultiplier(double charTimeMultiplier) {
		this.charTimeMultiplier = charTimeMultiplier;
	}

	public int getInstalledItemTypeID() {
		return installedItemTypeID;
	}

	public void setInstalledItemTypeID(int installedItemTypeID) {
		this.installedItemTypeID = installedItemTypeID;
	}

	public int getOutputTypeID() {
		return outputTypeID;
	}

	public void setOutputTypeID(int outputTypeID) {
		this.outputTypeID = outputTypeID;
	}

	public int getContainerTypeID() {
		return containerTypeID;
	}

	public void setContainerTypeID(int containerTypeID) {
		this.containerTypeID = containerTypeID;
	}

	public long getInstalledItemCopy() {
		return installedItemCopy;
	}

	public void setInstalledItemCopy(long installedItemCopy) {
		this.installedItemCopy = installedItemCopy;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public boolean isCompletedSuccessfully() {
		return completedSuccessfully;
	}

	public void setCompletedSuccessfully(boolean completedSuccessfully) {
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

	public Date getInstallTime() {
		return installTime;
	}

	public void setInstallTime(Date installTime) {
		this.installTime = installTime;
	}

	public Date getBeginProductionTime() {
		return beginProductionTime;
	}

	public void setBeginProductionTime(Date beginProductionTime) {
		this.beginProductionTime = beginProductionTime;
	}

	public Date getEndProductionTime() {
		return endProductionTime;
	}

	public void setEndProductionTime(Date endProductionTime) {
		this.endProductionTime = endProductionTime;
	}

	public Date getPauseProductionTime() {
		return pauseProductionTime;
	}

	public void setPauseProductionTime(Date pauseProductionTime) {
		this.pauseProductionTime = pauseProductionTime;
	}
}