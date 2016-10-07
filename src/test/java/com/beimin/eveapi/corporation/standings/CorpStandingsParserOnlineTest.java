package com.beimin.eveapi.corporation.standings;


import com.beimin.eveapi.AbstractOnlineTest;
import org.junit.Test;

import com.beimin.eveapi.parser.corporation.StandingsParser;
import com.beimin.eveapi.response.shared.StandingsResponse;

public class CorpStandingsParserOnlineTest extends AbstractOnlineTest {

	@Test
	public void getResponse() throws Exception {
		StandingsParser parser = new StandingsParser();
		StandingsResponse response = parser.getResponse(getCorp());
		testResponse(response);
	}

}