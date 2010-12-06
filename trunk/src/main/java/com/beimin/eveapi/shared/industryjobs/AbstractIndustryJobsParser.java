package com.beimin.eveapi.shared.industryjobs;


import org.apache.commons.digester.Digester;


import com.beimin.eveapi.core.AbstractApiParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

public abstract class AbstractIndustryJobsParser extends AbstractApiParser<IndustryJobsResponse> {
	protected AbstractIndustryJobsParser(ApiPath path) {
		super(IndustryJobsResponse.class, 2, path, ApiPage.INDUSTRY_JOBS);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", ApiIndustryJob.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addIndustryJob");
		return digester;
	}

	@Override
	public IndustryJobsResponse getResponse(ApiAuth auth) throws ApiException {
		return super.getResponse(auth);
	}
}