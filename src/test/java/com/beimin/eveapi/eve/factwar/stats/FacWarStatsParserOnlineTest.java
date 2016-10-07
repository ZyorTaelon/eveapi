package com.beimin.eveapi.eve.factwar.stats;


import com.beimin.eveapi.AbstractOnlineTest;

import org.junit.Test;

import com.beimin.eveapi.parser.eve.FacWarStatsParser;
import com.beimin.eveapi.response.eve.FacWarStatsResponse;

public class FacWarStatsParserOnlineTest extends AbstractOnlineTest {

	@Test
	public void getResponse() throws Exception {
		FacWarStatsParser parser = new FacWarStatsParser();
		FacWarStatsResponse response = parser.getResponse();
		testResponse(response);
	}

}