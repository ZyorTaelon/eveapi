package com.beimin.eveapi.server;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.text.ParseException;

import org.junit.Test;
import org.xml.sax.SAXException;

public class ServerStatusParserTest {

	@Test
	public void serverStatusParser() throws IOException, SAXException, ParseException, InterruptedException {
		ServerStatusParser parser = ServerStatusParser.getInstance();
		ServerStatusResponse response = parser.getServerStatus();
		assertNotNull(response);
	}
}