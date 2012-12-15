package com.beimin.eveapi.shared.industryjobs;

import org.xml.sax.Attributes;

import com.beimin.eveapi.core.AbstractContentListHandler;

public class IndustryJobsHandler extends AbstractContentListHandler<IndustryJobsResponse, ApiIndustryJob> {

	public IndustryJobsHandler() {
		super(IndustryJobsResponse.class);
	}

	@Override
	protected ApiIndustryJob getItem(Attributes attrs) {
		ApiIndustryJob job = new ApiIndustryJob();
		job.setJobID(getLong(attrs, "jobID"));
		job.setAssemblyLineID(getLong(attrs, "assemblyLineID"));
		job.setContainerID(getLong(attrs, "containerID"));
		job.setInstalledItemID(getLong(attrs, "installedItemID"));
		job.setInstalledItemLocationID(getLong(attrs, "installedItemLocationID"));
		job.setInstalledItemQuantity(getInt(attrs, "installedItemQuantity"));
		job.setInstalledItemProductivityLevel(getInt(attrs, "installedItemProductivityLevel"));
		job.setInstalledItemMaterialLevel(getInt(attrs, "installedItemMaterialLevel"));
		job.setInstalledItemLicensedProductionRunsRemaining(getInt(attrs, "installedItemLicensedProductionRunsRemaining"));
		job.setOutputLocationID(getInt(attrs, "outputLocationID"));
		job.setInstallerID(getLong(attrs, "installerID"));
		job.setRuns(getInt(attrs, "runs"));
		job.setLicensedProductionRuns(getInt(attrs, "licensedProductionRuns"));
		job.setInstalledInSolarSystemID(getLong(attrs, "installedInSolarSystemID"));
		job.setContainerLocationID(getLong(attrs, "containerLocationID"));
		job.setMaterialMultiplier(getDouble(attrs, "materialMultiplier"));
		job.setCharMaterialMultiplier(getDouble(attrs, "charMaterialMultiplier"));
		job.setTimeMultiplier(getDouble(attrs, "timeMultiplier"));
		job.setCharTimeMultiplier(getDouble(attrs, "charTimeMultiplier"));
		job.setInstalledItemTypeID(getInt(attrs, "installedItemTypeID"));
		job.setOutputTypeID(getInt(attrs, "outputTypeID"));
		job.setContainerTypeID(getInt(attrs, "containerTypeID"));
		job.setInstalledItemCopy(getInt(attrs, "installedItemCopy"));
		job.setCompleted(getBoolean(attrs, "completed"));
		job.setCompletedSuccessfully(getBoolean(attrs, "completedSuccessfully"));
		job.setInstalledItemFlag(getInt(attrs, "installedItemFlag"));
		job.setOutputFlag(getInt(attrs, "outputFlag"));
		job.setActivityID(getInt(attrs, "activityID"));
		job.setCompletedStatus(getInt(attrs, "completedStatus"));
		job.setInstallTime(getDate(attrs, "installTime"));
		job.setBeginProductionTime(getDate(attrs, "beginProductionTime"));
		job.setEndProductionTime(getDate(attrs, "endProductionTime"));
		job.setPauseProductionTime(getDate(attrs, "pauseProductionTime"));
		return job;
	}

}