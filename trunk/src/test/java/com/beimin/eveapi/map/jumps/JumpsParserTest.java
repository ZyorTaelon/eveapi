package com.beimin.eveapi.map.jumps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.Map;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.beimin.eveapi.ApiPage;
import com.beimin.eveapi.ApiPath;
import com.beimin.eveapi.utils.NoAuthParserTest;

public class JumpsParserTest extends NoAuthParserTest {
	public JumpsParserTest() {
		super(ApiPath.MAP, ApiPage.JUMPS);
	}

	@Test
	public void getResponse() throws IOException, SAXException {
		MapJumpsParser parser = MapJumpsParser.getInstance();
		MapJumpsResponse response = parser.getResponse();
		assertNotNull(response);
		Map<Integer, Integer> systemJumps = response.getSystemJumps();
		assertNotNull(systemJumps);
		assertEquals(4294L, systemJumps.size());
		assertEquals(1040L, systemJumps.get(30003504).longValue());
		assertEquals(13L, systemJumps.get(30003089).longValue());
		assertEquals(209L, systemJumps.get(30004978).longValue());
	}
}