package com.beimin.eveapi.corporation.titles;


import com.beimin.eveapi.AbstractOnlineTest;

import org.junit.Test;

import com.beimin.eveapi.parser.corporation.TitlesParser;
import com.beimin.eveapi.response.corporation.TitlesResponse;

public class TitlesParserOnlineTest extends AbstractOnlineTest {

	@Test
	public void getResponse() throws Exception {
		TitlesParser parser = new TitlesParser();
		TitlesResponse response = parser.getResponse(getCorp());
		testResponse(response);
	}

}