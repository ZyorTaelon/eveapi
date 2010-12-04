package com.beimin.eveapi.map.factwar.systems;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.beimin.eveapi.ApiPage;
import com.beimin.eveapi.ApiPath;
import com.beimin.eveapi.utils.NoAuthParserTest;

public class FacWarSystemsParserTest extends NoAuthParserTest {
	public FacWarSystemsParserTest() {
		super(ApiPath.MAP, ApiPage.FACTION_WAR_SYSTEMS);
	}

	@Test
	public void getResponse() throws IOException, SAXException {
		FacWarSystemsParser parser = FacWarSystemsParser.getInstance();
		FacWarSystemsResponse response = parser.getResponse();
		List<ApiFacWarSystem> systems = response.getSystems();
		assertEquals(171, systems.size());
		ApiFacWarSystem facWarSystem = systems.iterator().next();
		assertEquals(30002057, facWarSystem.getSolarSystemID());
		assertEquals("Hadozeko", facWarSystem.getSolarSystemName());
		assertEquals(0, facWarSystem.getOccupyingFactionID());
		assertEquals("", facWarSystem.getOccupyingFactionName());
		assertFalse("This system shouldn't be contested.", facWarSystem.isContested());
		facWarSystem = systems.get(93);
		assertEquals(30045344, facWarSystem.getSolarSystemID());
		assertEquals("Nennamaila", facWarSystem.getSolarSystemName());
		assertEquals(500001, facWarSystem.getOccupyingFactionID());
		assertEquals("Caldari State", facWarSystem.getOccupyingFactionName());
		assertTrue("This system shouldn't be contested.", facWarSystem.isContested());
	}
}