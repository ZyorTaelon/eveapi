package com.beimin.eveapi.corporation.starbase.detail;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;
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
		Calendar calendar = Calendar.getInstance();
		calendar.set(2008, 1, 3, 1, 54, 2);
		Date currentTime = calendar.getTime();
		assertEquals(currentTime.toString(), response.getCurrentTime().toString());
		calendar.set(2008, 1, 3, 7, 54, 2);
		Date cachedUntil = calendar.getTime();
		assertEquals(cachedUntil.toString(), response.getCachedUntil().toString());
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
