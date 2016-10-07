package com.beimin.eveapi.handler.shared;

import org.xml.sax.Attributes;

import com.beimin.eveapi.handler.AbstractContentListHandler;
import com.beimin.eveapi.model.shared.IndustryJob;
import com.beimin.eveapi.response.shared.IndustryJobsResponse;

public class IndustryJobsHandler extends AbstractContentListHandler<IndustryJobsResponse, IndustryJob> {

	public IndustryJobsHandler() {
		super(IndustryJobsResponse.class);
	}

	@Override
	protected IndustryJob getItem(Attributes attrs) {
		IndustryJob job = new IndustryJob();
		saveFieldsCount(IndustryJob.class, attrs);
		job.setJobID(getLong(attrs, "jobID"));
		job.setInstallerID(getLong(attrs, "installerID"));
		job.setInstallerName(getString(attrs, "installerName"));
		job.setFacilityID(getLong(attrs, "facilityID"));
		job.setSolarSystemID(getLong(attrs, "solarSystemID"));
		job.setSolarSystemName(getString(attrs, "solarSystemName"));
		job.setStationID(getLong(attrs, "stationID"));
		job.setActivityID(getInt(attrs, "activityID"));
		job.setBlueprintID(getLong(attrs, "blueprintID"));
		job.setBlueprintTypeID(getInt(attrs, "blueprintTypeID"));
		job.setBlueprintTypeName(getString(attrs, "blueprintTypeName"));
		job.setBlueprintLocationID(getLong(attrs, "blueprintLocationID"));
		job.setOutputLocationID(getLong(attrs, "outputLocationID"));
		job.setRuns(getInt(attrs, "runs"));
		job.setCost(getDouble(attrs, "cost"));
		job.setTeamID(getLong(attrs, "teamID"));
		job.setLicensedRuns(getInt(attrs, "licensedRuns"));
		job.setProbability(getDouble(attrs, "probability"));
		job.setProductTypeID(getInt(attrs, "productTypeID"));
		job.setProductTypeName(getString(attrs, "productTypeName"));
		job.setStatus(getInt(attrs, "status"));
		job.setTimeInSeconds(getInt(attrs, "timeInSeconds"));
		job.setStartDate(getDate(attrs, "startDate"));
		job.setEndDate(getDate(attrs, "endDate"));
		job.setPauseDate(getDate(attrs, "pauseDate"));
		job.setCompletedDate(getDate(attrs, "completedDate"));
		job.setCompletedCharacterID(getLong(attrs, "completedCharacterID"));
		return job;
	}

}