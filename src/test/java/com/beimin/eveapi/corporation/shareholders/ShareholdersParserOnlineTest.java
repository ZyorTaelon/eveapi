package com.beimin.eveapi.corporation.shareholders;


import com.beimin.eveapi.AbstractOnlineTest;

import org.junit.Test;

import com.beimin.eveapi.parser.corporation.ShareholdersParser;
import com.beimin.eveapi.response.corporation.ShareholdersResponse;

public class ShareholdersParserOnlineTest extends AbstractOnlineTest {

	@Test
	public void getResponse() throws Exception {
		ShareholdersParser parser = new ShareholdersParser();
		ShareholdersResponse response = parser.getResponse(getCorp());
		testResponse(response);
	}

}