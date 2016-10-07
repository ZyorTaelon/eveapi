package com.beimin.eveapi.map.jumps;


import com.beimin.eveapi.AbstractOnlineTest;

import org.junit.Test;

import com.beimin.eveapi.parser.map.JumpsParser;
import com.beimin.eveapi.response.map.JumpsResponse;

public class JumpsParserOnlineTest extends AbstractOnlineTest {

	@Test
	public void getResponse() throws Exception {
		JumpsParser parser = new JumpsParser();
		JumpsResponse response = parser.getResponse();
		testResponse(response);
	}

}