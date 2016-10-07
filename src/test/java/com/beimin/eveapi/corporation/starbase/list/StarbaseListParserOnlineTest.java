package com.beimin.eveapi.corporation.starbase.list;



import com.beimin.eveapi.AbstractOnlineTest;
import org.junit.Test;

import com.beimin.eveapi.parser.corporation.StarbaseListParser;
import com.beimin.eveapi.response.corporation.StarbaseListResponse;

public class StarbaseListParserOnlineTest extends AbstractOnlineTest {

	@Test
	public void getResponse() throws Exception {
		StarbaseListParser parser = new StarbaseListParser();
		StarbaseListResponse response = parser.getResponse(getCorp());
		testResponse(response);
	}

}