package com.beimin.eveapi.corporation.factwar.stats;


import com.beimin.eveapi.AbstractOnlineTest;
import org.junit.Test;

import com.beimin.eveapi.parser.corporation.FacWarStatsParser;
import com.beimin.eveapi.response.shared.FacWarStatsResponse;

public class CorpFacWarStatsParserOnlineTest extends AbstractOnlineTest {

	@Test
	public void getResponse() throws Exception {
		FacWarStatsParser parser = new FacWarStatsParser();
		FacWarStatsResponse facWarStatsResponse = parser.getResponse(getCorp());
		testResponse(facWarStatsResponse);
	}

}