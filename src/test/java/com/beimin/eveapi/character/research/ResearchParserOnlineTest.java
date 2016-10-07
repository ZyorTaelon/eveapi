package com.beimin.eveapi.character.research;


import com.beimin.eveapi.AbstractOnlineTest;

import org.junit.Test;

import com.beimin.eveapi.parser.pilot.ResearchParser;
import com.beimin.eveapi.response.pilot.ResearchResponse;

public class ResearchParserOnlineTest extends AbstractOnlineTest {

	@Test
	public void getResponse() throws Exception {
		ResearchParser parser = new ResearchParser();
		ResearchResponse response = parser.getResponse(getPilot());
		testResponse(response, 1);
	}

}