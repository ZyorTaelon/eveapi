package com.beimin.eveapi.server;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.ServerStatusParser;
import com.beimin.eveapi.response.ServerStatusResponse;
import com.beimin.eveapi.utils.NoAuthParserTest;

public class ServerStatusParserTest extends NoAuthParserTest {
	public ServerStatusParserTest() {
		super(ApiPath.SERVER, ApiPage.SERVER_STATUS);
	}

	@Test
	public void getResponse() throws ApiException {
		ServerStatusParser parser = new ServerStatusParser();
		ServerStatusResponse response = parser.getServerStatus();
		assertNotNull(response);
		assertEquals(38669, response.getOnlinePlayers());
		assertEquals(true, response.isServerOpen());
	}
}