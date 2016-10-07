package com.beimin.eveapi.eve.errorlist;


import com.beimin.eveapi.AbstractOnlineTest;

import org.junit.Test;

import com.beimin.eveapi.parser.eve.ErrorListParser;
import com.beimin.eveapi.response.eve.ErrorListResponse;

public class ErrorListParserOnlineTest extends AbstractOnlineTest {

	@Test
	public void getResponse() throws Exception {
		ErrorListParser parser = new ErrorListParser();
		ErrorListResponse response = parser.getResponse();
		testResponse(response);
	}

}