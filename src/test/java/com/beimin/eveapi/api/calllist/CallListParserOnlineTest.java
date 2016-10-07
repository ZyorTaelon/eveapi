package com.beimin.eveapi.api.calllist;


import com.beimin.eveapi.AbstractOnlineTest;

import org.junit.Test;

import com.beimin.eveapi.parser.calllist.CallListParser;
import com.beimin.eveapi.response.calllist.CallListResponse;

public class CallListParserOnlineTest extends AbstractOnlineTest {

	@Test
	public void getResponse() throws Exception {
		CallListParser parser = new CallListParser();
		CallListResponse response = parser.getResponse();
		testResponse(response);
	}

}
