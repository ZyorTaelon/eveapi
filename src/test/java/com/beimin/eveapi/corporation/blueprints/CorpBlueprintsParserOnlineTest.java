package com.beimin.eveapi.corporation.blueprints;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.corporation.BlueprintsParser;
import com.beimin.eveapi.response.shared.BlueprintsResponse;
import org.junit.Test;

public class CorpBlueprintsParserOnlineTest extends AbstractOnlineTest {

	@Test
	public void blueprintsParser() throws Exception {
		BlueprintsParser parser = new BlueprintsParser();
		BlueprintsResponse response = parser.getResponse(getCorp());
		testResponse(response);
	}

}