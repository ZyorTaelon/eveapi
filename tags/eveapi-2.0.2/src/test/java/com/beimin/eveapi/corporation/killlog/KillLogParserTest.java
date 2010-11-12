package com.beimin.eveapi.corporation.killlog;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.beimin.eveapi.shared.killlog.AbstractKillLogParser;
import com.beimin.eveapi.shared.killlog.ApiKill;
import com.beimin.eveapi.shared.killlog.ApiKillAttacker;
import com.beimin.eveapi.shared.killlog.ApiKillItem;
import com.beimin.eveapi.shared.killlog.ApiKillVictim;
import com.beimin.eveapi.shared.killlog.KillLogResponse;

public class KillLogParserTest {

	@Test
	public void killLogParser() throws IOException, SAXException, ParseException {
		AbstractKillLogParser parser = KillLogParser.getInstance();
		InputStream input = KillLogParserTest.class.getResourceAsStream("/corporation/KillLog.xml");
		KillLogResponse response = parser.getResponse(input);
		assertNotNull(response);
		Collection<ApiKill> entries = response.getKills();
		assertEquals(18, entries.size());
		boolean found = false;
		for (ApiKill kill : entries) {
			if (kill.getKillID() == 4879947) {
				found = true;
				Calendar calendar = Calendar.getInstance();
				calendar.set(Calendar.YEAR, 2008);
				calendar.set(Calendar.MONTH, 11);
				calendar.set(Calendar.DAY_OF_MONTH, 18);
				calendar.set(Calendar.HOUR_OF_DAY, 23);
				calendar.set(Calendar.MINUTE, 57);
				calendar.set(Calendar.SECOND, 0);
				calendar.set(Calendar.MILLISECOND, 0);
				assertEquals(calendar.getTime(), kill.getKillDateTime());
				ApiKillVictim victim = kill.getVictim();
				assertNotNull(victim);

				assertEquals(victim.getCharacterID(), 411109620);
				assertEquals(victim.getCharacterName(), "Pi'rat Tealon");
				assertEquals(victim.getCorporationID(), 1449814438);
				assertEquals(victim.getCorporationName(), "The Bastards");
				assertEquals(victim.getAllianceID().longValue(), 1311549668L);
				assertEquals(victim.getAllianceName(), "The Bastards.");
				assertEquals(victim.getFactionID(), 0);
				assertEquals(victim.getFactionName(), "");
				assertEquals(victim.getDamageTaken(), 1415);
				assertEquals(victim.getShipTypeID(), 587);

				List<ApiKillAttacker> attackers = kill.getAttackers();
				assertNotNull(attackers);
				assertEquals(1, attackers.size());
				ApiKillAttacker attacker = attackers.iterator().next();
				assertEquals(attacker.getCharacterID(), 1134301496);
				assertEquals(attacker.getCharacterName(), "Blackfiredaemon");
				assertEquals(attacker.getCorporationID(), 1885670269);
				assertEquals(attacker.getCorporationName(), "Letiferi Praedones");
				assertEquals(attacker.getAllianceID().longValue(), 1652934118L);
				assertEquals(attacker.getAllianceName(), "Wong Thong Crew");
				assertEquals(attacker.getFactionID(), 0);
				assertEquals(attacker.getFactionName(), "");
				assertEquals(attacker.getSecurityStatus(), -3.72675620703378, 1E-20d);
				assertEquals(attacker.getDamageDone(), 1415);
				assertEquals(attacker.isFinalBlow(), true);
				assertEquals(attacker.getWeaponTypeID(), 2897);
				assertEquals(attacker.getShipTypeID(), 11999);

				List<ApiKillItem> items = kill.getItems();
				assertNotNull(items);
				assertEquals(12, items.size());
			}
		}
		assertTrue("test KillLog entry wasn't found.", found);
	}
}