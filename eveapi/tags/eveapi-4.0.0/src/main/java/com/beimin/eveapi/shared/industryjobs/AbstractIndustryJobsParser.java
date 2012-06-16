package com.beimin.eveapi.shared.industryjobs;

import com.beimin.eveapi.core.AbstractListParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

public abstract class AbstractIndustryJobsParser extends AbstractListParser<IndustryJobsResponse, ApiIndustryJob> {
	protected AbstractIndustryJobsParser(ApiPath path) {
		super(IndustryJobsResponse.class, 2, path, ApiPage.INDUSTRY_JOBS, ApiIndustryJob.class);
	}

	@Override
	public IndustryJobsResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}