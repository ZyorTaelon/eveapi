package com.beimin.eveapi.eve.conquerablestationlist;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.eve.ConquerableStationListParser;
import com.beimin.eveapi.response.eve.StationListResponse;
import org.junit.Test;



public class ConquerableStationListParserOnlineTest extends AbstractOnlineTest {

	@Test
	public void getResponse() throws Exception {
		ConquerableStationListParser parser = new ConquerableStationListParser();
		StationListResponse response = parser.getResponse();
		testResponse(response);
	}

}