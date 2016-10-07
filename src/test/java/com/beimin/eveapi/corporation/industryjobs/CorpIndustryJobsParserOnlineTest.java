package com.beimin.eveapi.corporation.industryjobs;


import com.beimin.eveapi.AbstractOnlineTest;

import org.junit.Test;

import com.beimin.eveapi.parser.corporation.IndustryJobsParser;
import com.beimin.eveapi.parser.shared.AbstractIndustryJobsParser;
import com.beimin.eveapi.response.shared.IndustryJobsResponse;

public class CorpIndustryJobsParserOnlineTest extends AbstractOnlineTest {

	@Test
	public void getResponse() throws Exception {
		AbstractIndustryJobsParser parser = new IndustryJobsParser();
		IndustryJobsResponse response = parser.getResponse(getCorp());
		testResponse(response);
	}

}