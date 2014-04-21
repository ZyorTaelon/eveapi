package com.beimin.eveapi.character.killlog;

import static com.beimin.eveapi.utils.Assert.assertDate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.List;

import org.junit.Test;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.model.shared.Kill;
import com.beimin.eveapi.model.shared.KillAttacker;
import com.beimin.eveapi.model.shared.KillItem;
import com.beimin.eveapi.model.shared.KillVictim;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.pilot.KillLogParser;
import com.beimin.eveapi.parser.shared.AbstractKillLogParser;
import com.beimin.eveapi.response.shared.KillLogResponse;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class KillLogParserTest extends FullAuthParserTest {
	public KillLogParserTest() {
		super(ApiPath.CHARACTER, ApiPage.KILL_LOG);
	}

	@Test
	public void getResponse() throws ApiException {
		AbstractKillLogParser parser = new KillLogParser();
		KillLogResponse response = parser.getResponse(auth);
		assertNotNull(response);
		Collection<Kill> entries = response.getAll();
		assertEquals(18, entries.size());
		boolean found = false;
		for (Kill kill : entries) {
			if (kill.getKillID() == 4879947) {
				found = true;
				assertDate(2008, 12, 18, 23, 57, 0, kill.getKillTime());
				KillVictim victim = kill.getVictim();
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

				List<KillAttacker> attackers = kill.getAttackers();
				assertNotNull(attackers);
				assertEquals(1, attackers.size());
				KillAttacker attacker = attackers.iterator().next();
				assertEquals(attacker.getCharacterID(), 1134301496);
				assertEquals(attacker.getCharacterName(), "Blackfiredaemon");
				assertEquals(attacker.getCorporationID(), 1885670269);
				assertEquals(attacker.getCorporationName(), "Letiferi Praedones");
				assertEquals(attacker.getAllianceID().longValue(), 1652934118L);
				assertEquals(attacker.getAllianceName(), "Wong Thong Crew");
				assertEquals(attacker.getFactionID(), 0);
				assertEquals(attacker.getFactionName(), "");
				assertEquals(attacker.getSecurityStatus(), -3.72675620703378, 1E-15);
				assertEquals(attacker.getDamageDone(), 1415);
				assertEquals(attacker.isFinalBlow(), true);
				assertEquals(attacker.getWeaponTypeID(), 2897);
				assertEquals(attacker.getShipTypeID(), 11999);

				List<KillItem> items = kill.getItems();
				assertNotNull(items);
				assertEquals(12, items.size());
				KillItem item = items.iterator().next();
				assertEquals(530, item.getTypeID());
				assertEquals(0, item.getFlag());
				assertEquals(0, item.getQtyDropped());
				assertEquals(1, item.getQtyDestroyed());
			}
		}
		assertTrue("test KillLog entry wasn't found.", found);
	}
}