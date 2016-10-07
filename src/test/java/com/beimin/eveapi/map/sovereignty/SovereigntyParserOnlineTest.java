package com.beimin.eveapi.map.sovereignty;


import com.beimin.eveapi.AbstractOnlineTest;

import org.junit.Test;

import com.beimin.eveapi.parser.map.SovereigntyParser;
import com.beimin.eveapi.response.map.SovereigntyResponse;

public class SovereigntyParserOnlineTest extends AbstractOnlineTest {

	@Test
	public void getResponse() throws Exception {
		addEmptyOK("getAllianceID"); //No alliance
		addEmptyOK("getCorporationID"); //No corporation
		SovereigntyParser parser = new SovereigntyParser();
		SovereigntyResponse response = parser.getResponse();
		testResponse(response, 1);
	}

}