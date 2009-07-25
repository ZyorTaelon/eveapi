package com.beimin.eveapi.map.sovereignty;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.junit.Test;
import org.xml.sax.SAXException;

public class ParserTest {

	@Test
	public void testMapSovereigntyParser() throws IOException, SAXException {
		Parser parser = Parser.getInstance();
		InputStream input = ParserTest.class.getResourceAsStream("/Sovereignty.xml");
		Response response = parser.getResponse(input);
		assertNotNull(response);
		Map<Integer, ApiSystemSovereignty> systemSovereignties = response.getSystemSovereignties();
		assertNotNull(systemSovereignties);
		assertEquals(5382, systemSovereignties.size());

		ApiSystemSovereignty systemSovereignty = systemSovereignties.get(30000796);
		assertNotNull(systemSovereignty);
		assertEquals(1028876240, systemSovereignty.getAllianceID());
		assertEquals(0, systemSovereignty.getConstellationSovereignty());
		assertEquals(2, systemSovereignty.getSovereigntyLevel());
		assertEquals(0, systemSovereignty.getFactionID());
		assertEquals("EUU-4N", systemSovereignty.getSolarSystemName());

		systemSovereignty = systemSovereignties.get(30000074);
		assertNotNull(systemSovereignty);
		assertEquals(0, systemSovereignty.getAllianceID());
		assertEquals(0, systemSovereignty.getConstellationSovereignty());
		assertEquals(0, systemSovereignty.getSovereigntyLevel());
		assertEquals(500007, systemSovereignty.getFactionID());
		assertEquals("Hasateem", systemSovereignty.getSolarSystemName());
	}
}