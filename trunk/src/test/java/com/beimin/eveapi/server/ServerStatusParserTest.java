package com.beimin.eveapi.server;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.beimin.eveapi.ApiPage;
import com.beimin.eveapi.ApiPath;
import com.beimin.eveapi.utils.NoAuthParserTest;

public class ServerStatusParserTest extends NoAuthParserTest {
	public ServerStatusParserTest() {
		super(ApiPath.SERVER, ApiPage.SERVER_STATUS);
	}

	@Test
	public void getResponse() throws IOException, SAXException {
		ServerStatusParser parser = ServerStatusParser.getInstance();
		ServerStatusResponse response = parser.getServerStatus();
		assertNotNull(response);
		assertEquals(38669, response.getOnlinePlayers());
		assertEquals(true, response.isServerOpen());
	}
}