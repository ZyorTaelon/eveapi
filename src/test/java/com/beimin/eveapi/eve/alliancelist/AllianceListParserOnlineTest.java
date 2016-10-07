package com.beimin.eveapi.eve.alliancelist;


import com.beimin.eveapi.AbstractOnlineTest;

import org.junit.Test;

import com.beimin.eveapi.parser.eve.AllianceListParser;
import com.beimin.eveapi.response.eve.AllianceListResponse;

public class AllianceListParserOnlineTest extends AbstractOnlineTest {

	@Test
	public void getResponse() throws Exception {
		AllianceListParser parser = new AllianceListParser();
		AllianceListResponse response = parser.getResponse();
		testResponse(response);
	}

}