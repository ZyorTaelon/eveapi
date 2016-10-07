package com.beimin.eveapi.character.standings;


import com.beimin.eveapi.AbstractOnlineTest;
import org.junit.Test;

import com.beimin.eveapi.parser.pilot.StandingsParser;
import com.beimin.eveapi.response.shared.StandingsResponse;

public class CharStandingsParserOnlineTest extends AbstractOnlineTest {

	@Test
	public void getResponse() throws Exception {
		StandingsParser parser = new StandingsParser();
		StandingsResponse response = parser.getResponse(getPilot());
		testResponse(response);
	}

}