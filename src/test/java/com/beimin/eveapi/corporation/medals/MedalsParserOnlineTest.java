package com.beimin.eveapi.corporation.medals;


import com.beimin.eveapi.AbstractOnlineTest;

import org.junit.Test;

import com.beimin.eveapi.parser.corporation.MedalsParser;
import com.beimin.eveapi.response.corporation.MedalsResponse;

public class MedalsParserOnlineTest extends AbstractOnlineTest {

	@Test
	public void getResponse() throws Exception {
		MedalsParser parser = new MedalsParser();
		MedalsResponse response = parser.getResponse(getCorp());
		testResponse(response);
	}

}