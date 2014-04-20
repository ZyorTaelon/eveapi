package com.beimin.eveapi.map.sovereignty;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Map;

import org.junit.Test;

import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.utils.NoAuthParserTest;

public class SovereigntyParserTest extends NoAuthParserTest {
	public SovereigntyParserTest() {
		super(ApiPath.MAP, ApiPage.SOVEREIGNTY);
	}

	@Test
	public void getResponse() throws ApiException {
		SovereigntyParser parser = new SovereigntyParser();
		SovereigntyResponse response = parser.getResponse();
		assertNotNull(response);
		Map<Integer, ApiSystemSovereignty> systemSovereignties = response.getSystemSovereignties();
		assertNotNull(systemSovereignties);
		assertEquals(5382, systemSovereignties.size());

		ApiSystemSovereignty systemSovereignty = systemSovereignties.get(30000796);
		assertNotNull(systemSovereignty);
		assertEquals(1028876240, systemSovereignty.getAllianceID());
		assertEquals(0, systemSovereignty.getFactionID().intValue());
		assertEquals("EUU-4N", systemSovereignty.getSolarSystemName());

		systemSovereignty = systemSovereignties.get(30000074);
		assertNotNull(systemSovereignty);
		assertEquals(0, systemSovereignty.getAllianceID());
		assertEquals(500007, systemSovereignty.getFactionID().intValue());
		assertEquals("Hasateem", systemSovereignty.getSolarSystemName());
	}
}