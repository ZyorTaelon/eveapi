package com.beimin.eveapi.character.standings;

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
		InputStream input = StandingsParserTest.class.getResourceAsStream("/character/Standings.xml");
		StandingsResponse response = parser.getResponse(input);
		assertNotNull(response);

		Collection<StandingsList> characterStandingsLists = response.getStandingsLists();
		assertNotNull(characterStandingsLists);
		assertEquals(3, characterStandingsLists.size());
		for (StandingsList standingsList : characterStandingsLists) {
			assertNotNull(standingsList);
			String name = standingsList.getName();
			if (name.equals("agents")) {
				assertEquals(116, standingsList.size());
				ApiStanding apiStanding = standingsList.iterator().next();
				assertEquals(3008577, apiStanding.getID());
				assertEquals("Namai Manir", apiStanding.getName());
				assertEquals(0.07, apiStanding.getStanding(), 1E-15);
			} else if (name.equals("NPCCorporations")) {
				assertEquals(51, standingsList.size());
				ApiStanding apiStanding = standingsList.iterator().next();
				assertEquals(1000002, apiStanding.getID());
				assertEquals("CBD Corporation", apiStanding.getName());
				assertEquals(1.08, apiStanding.getStanding(), 1E-15);
			} else if (name.equals("factions")) {
				assertEquals(20, standingsList.size());
				ApiStanding apiStanding = standingsList.iterator().next();
				assertEquals(500001, apiStanding.getID());
				assertEquals("Caldari State", apiStanding.getName());
				assertEquals(-1.95, apiStanding.getStanding(), 1E-15);
			}
		}
	}
}