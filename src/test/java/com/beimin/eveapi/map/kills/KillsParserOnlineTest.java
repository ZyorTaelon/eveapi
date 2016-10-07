package com.beimin.eveapi.map.kills;


import com.beimin.eveapi.AbstractOnlineTest;

import org.junit.Test;

import com.beimin.eveapi.parser.map.KillsParser;
import com.beimin.eveapi.response.map.KillsResponse;

public class KillsParserOnlineTest extends AbstractOnlineTest {

	@Test
	public void getResponse() throws Exception {
		addEmptyOK("getShipKills->MapValue"); //No ship kills
		addEmptyOK("getPodKills->MapValue"); //No pod kills
		KillsParser parser = new KillsParser();
		KillsResponse response = parser.getResponse();
		testResponse(response);
	}

}