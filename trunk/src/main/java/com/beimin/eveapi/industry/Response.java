package com.beimin.eveapi.industry;

import java.util.ArrayList;
import java.util.Collection;

import com.beimin.eveapi.ApiResponse;

public class Response extends ApiResponse {
	private final Collection<IndustryJob> industryJobs = new ArrayList<IndustryJob>();

	public void addIndustryJob(IndustryJob industryJob) {
		industryJobs.add(industryJob);
	}

	public Collection<IndustryJob> getIndustryJobs() {
		return industryJobs;
	}
}