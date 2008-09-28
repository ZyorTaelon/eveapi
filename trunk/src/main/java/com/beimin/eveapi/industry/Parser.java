package com.beimin.eveapi.industry;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;

public class Parser extends AbstractApiParser<Response> {
	protected static final String INDUSTRY_JOBS_URL = "/IndustryJobs.xml.aspx";

	public Parser() {
		super(Response.class);
	}

	public Response getInustryJobs(ApiAuth auth, boolean corporation) throws IOException, SAXException {
		String requestUrl = EVE_API_URL;
		if (corporation)
			requestUrl += CORP_PATH;
		else
			requestUrl += CHAR_PATH;
		requestUrl += INDUSTRY_JOBS_URL;
		requestUrl += auth.getUrlParams();
		requestUrl += "&version=2";
		return getResponse(requestUrl, getDigester());
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", IndustryJob.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addIndustryJob");
		return digester;
	}

	public static Parser getInstance() {
		return new Parser();
	}
}