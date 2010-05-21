package com.beimin.eveapi.map.sovereignty;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.junit.Test;
import org.xml.sax.SAXException;

public class SovereigntyParserTest {

	@Test
	public void mapSovereigntyParser() throws IOException, SAXException {
		MapSovereigntyParser parser = MapSovereigntyParser.getInstance();
		InputStream input = SovereigntyParserTest.class.getResourceAsStream("/map/Sovereignty.xml");
		MapSovereigntyResponse response = parser.getResponse(input);
		assertNotNull(response);
		Map<Integer, ApiSystemSovereignty> systemSovereignties = response.getSystemSovereignties();
		assertNotNull(systemSovereignties);
		assertEquals(5382, systemSovereignties.size());

		ApiSystemSovereignty systemSovereignty = systemSovereignties.get(30000796);
		assertNotNull(systemSovereignty);
		assertEquals(1028876240, systemSovereignty.getAllianceID());
		assertEquals(0, systemSovereignty.getFactionID());
		assertEquals("EUU-4N", systemSovereignty.getSolarSystemName());

		systemSovereignty = systemSovereignties.get(30000074);
		assertNotNull(systemSovereignty);
		assertEquals(0, systemSovereignty.getAllianceID());
		assertEquals(500007, systemSovereignty.getFactionID());
		assertEquals("Hasateem", systemSovereignty.getSolarSystemName());
	}
}