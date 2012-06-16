package com.beimin.eveapi.server;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


import org.junit.Test;


import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.utils.NoAuthParserTest;

public class ServerStatusParserTest extends NoAuthParserTest {
	public ServerStatusParserTest() {
		super(ApiPath.SERVER, ApiPage.SERVER_STATUS);
	}

	@Test
	public void getResponse() throws ApiException {
		ServerStatusParser parser = ServerStatusParser.getInstance();
		ServerStatusResponse response = parser.getServerStatus();
		assertNotNull(response);
		assertEquals(38669, response.getOnlinePlayers());
		assertEquals(true, response.isServerOpen());
	}
}