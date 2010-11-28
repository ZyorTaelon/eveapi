package com.beimin.eveapi.corporation.standings;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.Collection;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.beimin.eveapi.shared.standings.ApiStanding;
import com.beimin.eveapi.shared.standings.StandingsList;
import com.beimin.eveapi.shared.standings.StandingsResponse;

public class StandingsParserTest {

	@Test
	public void standingsParser() throws IOException, SAXException, ParseException {
		StandingsParser parser = StandingsParser.getInstance();
		InputStream input = StandingsParserTest.class.getResourceAsStream("/corporation/Standings.xml");
		StandingsResponse response = parser.getResponse(input);
		assertNotNull(response);

		Collection<StandingsList> corporationStandingsLists = response.getStandingsLists();
		assertNotNull(corporationStandingsLists);
		assertEquals(3, corporationStandingsLists.size());
		for (StandingsList standingsList : corporationStandingsLists) {
			assertNotNull(standingsList);
			String name = standingsList.getName();
			if (name.equals("agents")) {
				assertEquals(1871, standingsList.size());
				ApiStanding apiStanding = standingsList.iterator().next();
				assertEquals(3008420, apiStanding.getID());
				assertEquals("Appi Intaa", apiStanding.getName());
				assertEquals(-0.33, apiStanding.getStanding(), 1E-15);
			} else if (name.equals("NPCCorporations")) {
				assertEquals(154, standingsList.size());
				ApiStanding apiStanding = standingsList.iterator().next();
				assertEquals(1000002, apiStanding.getID());
				assertEquals("CBD Corporation", apiStanding.getName());
				assertEquals(0.52, apiStanding.getStanding(), 1E-15);
			} else if (name.equals("factions")) {
				assertEquals(20, standingsList.size());
				ApiStanding apiStanding = standingsList.iterator().next();
				assertEquals(500001, apiStanding.getID());
				assertEquals("Caldari State", apiStanding.getName());
				assertEquals(1.47, apiStanding.getStanding(), 1E-15);
			}
		}
	}
}