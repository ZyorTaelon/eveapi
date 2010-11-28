package com.beimin.eveapi.corporation.starbase.detail;

import static com.beimin.eveapi.utils.Assert.assertDate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.junit.Test;
import org.xml.sax.SAXException;

public class StarbaseDetailParserTest {

	@Test
	public void starbaseDetail() throws IOException, SAXException {
		StarbaseDetailParser parser = StarbaseDetailParser.getInstance();
		InputStream input = StarbaseDetailParserTest.class.getResourceAsStream("/corporation/StarbaseDetail.xml");
		StarbaseDetailResponse response = parser.getResponse(input);
		assertNotNull("Should have returned a result.", response);
		assertDate(2008, 2, 3, 1, 54, 2, response.getCurrentTime());
		assertDate(2008, 2, 3, 7, 54, 2, response.getCachedUntil());
		assertEquals(3, response.getUsageFlags());
		assertEquals(0, response.getDeployFlags());
		assertTrue(response.isAllowCorporationMembers());
		assertFalse(response.isAllowAllianceMembers());
		assertTrue(response.isClaimSovereignty());
		ApiCombatSetting onStandingDrop = response.getOnStandingDrop();
		assertNotNull("Should have a CombatSetting for standing drop.", onStandingDrop);
		assertFalse(onStandingDrop.isEnabled());
		assertEquals(10, onStandingDrop.getStanding());
		ApiCombatSetting onStatusDrop = response.getOnStatusDrop();
		assertNotNull("Should have a CombatSetting for status drop.", onStatusDrop);
		assertFalse(onStatusDrop.isEnabled());
		assertEquals(0, onStatusDrop.getStanding());
		ApiCombatSetting onAggression = response.getOnAggression();
		assertNotNull("Should have a CombatSetting for aggression.", onAggression);
		assertFalse(onAggression.isEnabled());
		ApiCombatSetting onCorporationWar = response.getOnCorporationWar();
		assertNotNull("Should have a CombatSetting for war.", onCorporationWar);
		assertTrue(onCorporationWar.isEnabled());
		Map<Integer, Integer> fuelMap = response.getFuelMap();
		assertNotNull("Should have a fuelMap.", fuelMap);
		assertEquals(423L, fuelMap.get(44).longValue());
		assertEquals(2542L, fuelMap.get(3683).longValue());
		assertEquals(850L, fuelMap.get(3689).longValue());
		assertEquals(850L, fuelMap.get(9832).longValue());
		assertEquals(423L, fuelMap.get(9848).longValue());
		assertEquals(10800L, fuelMap.get(16272).longValue());
		assertEquals(4878L, fuelMap.get(16273).longValue());
		assertEquals(35955L, fuelMap.get(16274).longValue());
		assertEquals(150L, fuelMap.get(16275).longValue());
	}
}
