package com.beimin.eveapi.corporation.outpost.list;


import com.beimin.eveapi.AbstractOnlineTest;

import org.junit.Test;

import com.beimin.eveapi.parser.corporation.OutpostListParser;
import com.beimin.eveapi.response.corporation.OutpostListResponse;

public class OutpostListParserOnlineTest extends AbstractOnlineTest {

	@Test
	public void getResponse() throws Exception {
		OutpostListParser parser = new OutpostListParser();
		OutpostListResponse response = parser.getResponse(getCorp());
		testResponse(response);
	}

}