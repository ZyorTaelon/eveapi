package com.beimin.eveapi.parser.shared;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.shared.IndustryJobsHandler;
import com.beimin.eveapi.model.shared.IndustryJob;
import com.beimin.eveapi.parser.ApiAuth;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.response.shared.IndustryJobsResponse;

public abstract class AbstractIndustryJobsParser extends AbstractListParser<IndustryJobsHandler, IndustryJobsResponse, IndustryJob> {
	protected AbstractIndustryJobsParser(ApiPath path) {
		super(IndustryJobsResponse.class, 2, path, ApiPage.INDUSTRY_JOBS, IndustryJobsHandler.class);
	}

	@Override
	public IndustryJobsResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}