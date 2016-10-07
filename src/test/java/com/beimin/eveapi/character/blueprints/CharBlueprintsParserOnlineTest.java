package com.beimin.eveapi.character.blueprints;


import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.pilot.BlueprintsParser;
import com.beimin.eveapi.response.shared.BlueprintsResponse;
import org.junit.Test;

public class CharBlueprintsParserOnlineTest extends AbstractOnlineTest {

	@Test
	public void blueprintsParser() throws Exception {
		BlueprintsParser parser = new BlueprintsParser();
		BlueprintsResponse response = parser.getResponse(getPilot());
		testResponse(response);
	}

}