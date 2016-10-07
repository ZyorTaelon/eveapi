package com.beimin.eveapi.character.industryjobs;


import com.beimin.eveapi.AbstractOnlineTest;

import org.junit.Test;

import com.beimin.eveapi.parser.pilot.IndustryJobsParser;
import com.beimin.eveapi.parser.shared.AbstractIndustryJobsParser;
import com.beimin.eveapi.response.shared.IndustryJobsResponse;

public class CharIndustryJobsParserOnlineTest extends AbstractOnlineTest {

	@Test
	public void getResponse() throws Exception {
		AbstractIndustryJobsParser parser = new IndustryJobsParser();
		IndustryJobsResponse response = parser.getResponse(getPilot());
		testResponse(response);
	}

}