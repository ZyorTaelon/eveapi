package com.beimin.eveapi.map.kills;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.junit.Test;
import org.xml.sax.SAXException;

public class KillsParserTest {

	@Test
	public void mapKillsParser() throws IOException, SAXException {
		MapKillsParser parser = MapKillsParser.getInstance();
		InputStream input = KillsParserTest.class.getResourceAsStream("/map/Kills.xml");
		MapKillsResponse response = parser.getResponse(input);
		assertNotNull(response);
		Map<Integer, Integer> shipKills = response.getShipKills();
		assertNotNull(shipKills);
		assertEquals(2603, shipKills.size());
		Map<Integer, Integer> factionKills = response.getFactionKills();
		assertNotNull(factionKills);
		assertEquals(2603, factionKills.size());
		Map<Integer, Integer> podKills = response.getPodKills();
		assertNotNull(podKills);
		assertEquals(2603, podKills.size());
		assertEquals(3, shipKills.get(30001001).longValue());
		assertEquals(203, factionKills.get(30001001).longValue());
		assertEquals(5, podKills.get(30001001).longValue());
		assertEquals(0, shipKills.get(30001039).longValue());
		assertEquals(40, factionKills.get(30001039).longValue());
		assertEquals(0, podKills.get(30001039).longValue());
	}
}