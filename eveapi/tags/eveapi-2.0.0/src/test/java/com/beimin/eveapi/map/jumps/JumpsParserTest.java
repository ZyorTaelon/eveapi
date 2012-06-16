package com.beimin.eveapi.map.jumps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.junit.Test;
import org.xml.sax.SAXException;

public class JumpsParserTest {

	@Test
	public void mapJumpsParser() throws IOException, SAXException {
		MapJumpsParser parser = MapJumpsParser.getInstance();
		InputStream input = JumpsParserTest.class.getResourceAsStream("/map/Jumps.xml");
		MapJumpsResponse response = parser.getResponse(input);
		assertNotNull(response);
		Map<Integer, Integer> systemJumps = response.getSystemJumps();
		assertNotNull(systemJumps);
		assertEquals(4294, systemJumps.size());
		assertEquals(1040, systemJumps.get(30003504));
		assertEquals(13, systemJumps.get(30003089));
		assertEquals(209, systemJumps.get(30004978));
	}
}