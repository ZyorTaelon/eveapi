package com.beimin.eveapi.shared.industryjobs;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;

public class IndustryJobsParser extends AbstractApiParser<IndustryJobsResponse> {
	protected static final String INDUSTRY_JOBS_URL = "/IndustryJobs.xml.aspx";

	public IndustryJobsParser() {
		super(IndustryJobsResponse.class, 2, INDUSTRY_JOBS_URL);
	}

	public IndustryJobsResponse getInustryJobs(ApiAuth auth, boolean corporation) throws IOException, SAXException {
		if (corporation)
			return getResponse(auth, Path.CORP);
		return getResponse(auth, Path.CHARACTER);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", ApiIndustryJob.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addIndustryJob");
		return digester;
	}

	public static IndustryJobsParser getInstance() {
		return new IndustryJobsParser();
	}
}