package com.beimin.eveapi.shared.industryjobs;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;
import com.beimin.eveapi.ApiPage;
import com.beimin.eveapi.ApiPath;

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

	public IndustryJobsResponse getResponse(ApiAuth auth) throws IOException, SAXException {
		return super.getResponse(auth);
	}
}