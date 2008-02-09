package com.beimin.eveapi.starbase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.betterbe.eveapi.starbase.CombatSetting;
import com.betterbe.eveapi.starbase.DetailParser;
import com.betterbe.eveapi.starbase.DetailResponse;

public class DetailParserTest {

	@Test
	public void getDetail() throws IOException, SAXException {
		DetailParser parser = DetailParser.getInstance();
		InputStream input = DetailParserTest.class.getResourceAsStream("/StarbaseDetail.xml");
		DetailResponse response = parser.getDetail(input);
		assertNotNull("Should have returned a result.", response);
		assertEquals("Sun Feb 03 01:54:02 CET 2008", response.getCurrentTime().toString());
		assertEquals("Sun Feb 03 07:54:02 CET 2008", response.getCachedUntil().toString());
		assertEquals(3, response.getUsageFlags());
		assertEquals(0, response.getDeployFlags());
		assertTrue(response.isAllowCorporationMembers());
		assertFalse(response.isAllowAllianceMembers());
		assertTrue(response.isClaimSovereignty());
		CombatSetting onStandingDrop = response.getOnStandingDrop();
		assertNotNull("Should have a CombatSetting for standing drop.", onStandingDrop);
		assertFalse(onStandingDrop.isEnabled());
		assertEquals(10, onStandingDrop.getStanding());
		CombatSetting onStatusDrop = response.getOnStatusDrop();
		assertNotNull("Should have a CombatSetting for status drop.", onStatusDrop);
		assertFalse(onStatusDrop.isEnabled());
		assertEquals(0, onStatusDrop.getStanding());
		CombatSetting onAggression = response.getOnAggression();
		assertNotNull("Should have a CombatSetting for aggression.", onAggression);
		assertFalse(onAggression.isEnabled());
		CombatSetting onCorporationWar = response.getOnCorporationWar();
		assertNotNull("Should have a CombatSetting for war.", onCorporationWar);
		assertTrue(onCorporationWar.isEnabled());
		Map<Integer, Integer> fuelMap = response.getFuelMap();
		assertNotNull("Should have a fuelMap.", fuelMap);
		assertEquals(423, fuelMap.get(44));
		assertEquals(2542, fuelMap.get(3683));
		assertEquals(850, fuelMap.get(3689));
		assertEquals(850, fuelMap.get(9832));
		assertEquals(423, fuelMap.get(9848));
		assertEquals(10800, fuelMap.get(16272));
		assertEquals(4878, fuelMap.get(16273));
		assertEquals(35955, fuelMap.get(16274));
		assertEquals(150, fuelMap.get(16275));
	}
}
