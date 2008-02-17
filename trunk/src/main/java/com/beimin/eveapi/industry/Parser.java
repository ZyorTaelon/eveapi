package com.beimin.eveapi.industry;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuthorization;

public class Parser extends AbstractApiParser<Response> {
	protected static final String INDUSTRY_JOBS_URL = "/IndustryJobs.xml.aspx";

	public Parser() {
		super(Response.class);
	}

	public Response getInustryJobs(ApiAuthorization auth, boolean corporation) throws IOException, SAXException {
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
		// TODO: Create Industry Jobs digester.
		return digester;
	}

	public static Parser getInstance() {
		return new Parser();
	}
}