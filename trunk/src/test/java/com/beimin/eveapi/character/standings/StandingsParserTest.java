package com.beimin.eveapi.character.standings;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.beimin.eveapi.ApiPage;
import com.beimin.eveapi.ApiPath;
import com.beimin.eveapi.shared.standings.ApiStanding;
import com.beimin.eveapi.shared.standings.StandingsList;
import com.beimin.eveapi.shared.standings.StandingsResponse;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class StandingsParserTest extends FullAuthParserTest {
	public StandingsParserTest() {
		super(ApiPath.CHARACTER, ApiPage.STANDINGS);
	}

	@Test
	public void getResponse() throws IOException, SAXException {
		StandingsParser parser = StandingsParser.getInstance();
		StandingsResponse response = parser.getResponse(auth);
		assertNotNull(response);

		StandingsList agentStandings = response.getAgentStandings();
		assertEquals("agents", agentStandings.getName());
		assertEquals(116, agentStandings.size());
		ApiStanding apiStanding = agentStandings.iterator().next();
		assertEquals(3008577, apiStanding.getFromID());
		assertEquals("Namai Manir", apiStanding.getFromName());
		assertEquals(0.07, apiStanding.getStanding(), 1E-15);

		StandingsList npcCorporations = response.getNpcCorporationStandings();
		assertEquals("NPCCorporations", npcCorporations.getName());
		assertEquals(51, npcCorporations.size());
		apiStanding = npcCorporations.iterator().next();
		assertEquals(1000002, apiStanding.getFromID());
		assertEquals("CBD Corporation", apiStanding.getFromName());
		assertEquals(1.08, apiStanding.getStanding(), 1E-15);

		StandingsList factionStandings = response.getFactionStandings();
		assertEquals("factions", factionStandings.getName());
		assertEquals(20, factionStandings.size());
		apiStanding = factionStandings.iterator().next();
		assertEquals(500001, apiStanding.getFromID());
		assertEquals("Caldari State", apiStanding.getFromName());
		assertEquals(-1.95, apiStanding.getStanding(), 1E-15);
	}
}