package com.beimin.eveapi.server;


import com.beimin.eveapi.AbstractOnlineTest;
import org.junit.Test;

import com.beimin.eveapi.parser.ServerStatusParser;
import com.beimin.eveapi.response.ServerStatusResponse;

public class ServerStatusParserOnlineTest extends AbstractOnlineTest {

	@Test
	public void getResponse() throws Exception {
		ServerStatusParser parser = new ServerStatusParser();
		ServerStatusResponse response = parser.getServerStatus();
		testResponse(response);
	}

}