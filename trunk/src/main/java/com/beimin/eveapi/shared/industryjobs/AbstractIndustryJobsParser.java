package com.beimin.eveapi.shared.industryjobs;

import java.io.IOException;
import java.util.Collection;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;

public abstract class AbstractIndustryJobsParser extends AbstractApiParser<IndustryJobsResponse> {
	protected static final String INDUSTRY_JOBS_URL = "/IndustryJobs";
	private final Path path;

	protected AbstractIndustryJobsParser(Path path) {
		super(IndustryJobsResponse.class, 2, INDUSTRY_JOBS_URL);
		this.path = path;
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", ApiIndustryJob.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addIndustryJob");
		return digester;
	}
	
	public IndustryJobsResponse getIndustryJobsResponse(ApiAuth auth) throws IOException, SAXException {
		return getResponse(auth, path);
	}
	
	public Collection<ApiIndustryJob> getIndustryJobs(ApiAuth auth) throws IOException, SAXException{
		return getIndustryJobsResponse(auth).getIndustryJobs();
	}
}