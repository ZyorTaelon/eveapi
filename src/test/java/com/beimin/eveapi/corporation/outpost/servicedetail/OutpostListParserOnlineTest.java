package com.beimin.eveapi.corporation.outpost.servicedetail;


import com.beimin.eveapi.AbstractOnlineTest;

import org.junit.Test;

import com.beimin.eveapi.parser.corporation.OutpostServiceDetailParser;
import com.beimin.eveapi.response.corporation.OutpostServiceDetailResponse;

public class OutpostListParserOnlineTest extends AbstractOnlineTest {

	@Test
	public void getResponse() throws Exception {
		OutpostServiceDetailParser parser = new OutpostServiceDetailParser();
		OutpostServiceDetailResponse response = parser.getResponse(getCorp());
		testResponse(response);
	}

}