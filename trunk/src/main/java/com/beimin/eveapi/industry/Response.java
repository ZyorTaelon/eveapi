package com.beimin.eveapi.industry;

import java.util.ArrayList;
import java.util.Collection;

import com.beimin.eveapi.ApiResponse;

public class Response extends ApiResponse {
	private final Collection<ApiIndustryJob> industryJobs = new ArrayList<ApiIndustryJob>();

	public void addIndustryJob(ApiIndustryJob industryJob) {
		industryJobs.add(industryJob);
	}

	public Collection<ApiIndustryJob> getIndustryJobs() {
		return industryJobs;
	}
}