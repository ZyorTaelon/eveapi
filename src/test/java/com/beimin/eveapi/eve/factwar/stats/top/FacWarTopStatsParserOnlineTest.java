package com.beimin.eveapi.eve.factwar.stats.top;


import com.beimin.eveapi.AbstractOnlineTest;
import org.junit.Test;

import com.beimin.eveapi.parser.eve.FacWarTopStatsParser;
import com.beimin.eveapi.response.eve.FacWarTopStatsResponse;

public class FacWarTopStatsParserOnlineTest extends AbstractOnlineTest {

	@Test
	public void getResponse() throws Exception {
		//Always include one respose with one row with getCharacterID="0" and getCharacterName=""
		addEmptyOK("getCharacterID");
		addEmptyOK("getCharacterName");
		//Always include one respose with one row with getCorporationID="0" and getCharacterName=""
		addEmptyOK("getCorporationID");
		addEmptyOK("getCharacterName");
		FacWarTopStatsParser parser = new FacWarTopStatsParser();
		FacWarTopStatsResponse response = parser.getResponse();
		testResponse(response);
	}

}