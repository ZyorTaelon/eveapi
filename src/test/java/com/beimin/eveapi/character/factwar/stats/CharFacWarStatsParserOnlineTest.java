package com.beimin.eveapi.character.factwar.stats;


import com.beimin.eveapi.AbstractOnlineTest;
import org.junit.Test;

import com.beimin.eveapi.parser.pilot.FacWarStatsParser;
import com.beimin.eveapi.response.shared.FacWarStatsResponse;

public class CharFacWarStatsParserOnlineTest extends AbstractOnlineTest {

	@Test
	public void getResponse() throws Exception {
		FacWarStatsParser parser = new FacWarStatsParser();
		FacWarStatsResponse facWarStatsResponse = parser.getResponse(getPilot());
		testResponse(facWarStatsResponse);
	}

}