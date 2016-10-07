package com.beimin.eveapi.character.medals;


import com.beimin.eveapi.AbstractOnlineTest;

import org.junit.Test;

import com.beimin.eveapi.parser.pilot.MedalsParser;
import com.beimin.eveapi.response.pilot.MedalsResponse;


public class MedalsParserOnlineTest extends AbstractOnlineTest {

	@Test
	public void getResponse() throws Exception {
		MedalsParser parser = new MedalsParser();
		MedalsResponse response = parser.getResponse(getPilot());
		testResponse(response);
	}

}