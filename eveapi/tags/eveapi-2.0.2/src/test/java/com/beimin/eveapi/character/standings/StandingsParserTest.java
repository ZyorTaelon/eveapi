package com.beimin.eveapi.character.standings;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.Collection;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.beimin.eveapi.shared.standings.ApiStanding;
import com.beimin.eveapi.shared.standings.StandingsList;

public class StandingsParserTest {

	@Test
	public void standingsParser() throws IOException, SAXException, ParseException {
		StandingsParser parser = StandingsParser.getInstance();
		InputStream input = StandingsParserTest.class.getResourceAsStream("/character/Standings.xml");
		StandingsResponse response = parser.getResponse(input);
		assertNotNull(response);
		
		Collection<StandingsList> characterStandingsTo = response.getStandingsTo();
		assertNotNull(characterStandingsTo);
		assertEquals(2, characterStandingsTo.size());
		for (StandingsList standingsList : characterStandingsTo) {
			assertNotNull(standingsList);
			String name = standingsList.getName();
			if(name.equals("characters")) {
				assertEquals(0, standingsList.size());
			} else if(name.equals("corporations")) {
				assertEquals(1, standingsList.size());
				ApiStanding apiStanding = standingsList.iterator().next();
				assertEquals(1508869323, apiStanding.getID());
				assertEquals("Sileo In Pacis", apiStanding.getName());
				assertEquals(-2.00, apiStanding.getStanding(), 1E-15);
			}
		}
		
		Collection<StandingsList> characterStandingsFrom = response.getStandingsFrom();
		assertNotNull(characterStandingsFrom);
		assertEquals(3, characterStandingsFrom.size());
		for (StandingsList standingsList : characterStandingsFrom) {
			assertNotNull(standingsList);
			String name = standingsList.getName();
			if(name.equals("agents")) {
				assertEquals(35, standingsList.size());
				boolean found = false;
				for (ApiStanding apiStanding : standingsList) {
					if(apiStanding.getID() == 3009237) {
						found = true;
						assertEquals(3009237, apiStanding.getID());
						assertEquals("Ardoroule Ophone", apiStanding.getName());
						assertEquals(4.68, apiStanding.getStanding(), 1E-15);
					}
				}
				assertTrue("Test standing not found", found);
			} else if(name.equals("NPCCorporations")) {
				assertEquals(20, standingsList.size());
			} else if(name.equals("factions")) {
				assertEquals(18, standingsList.size());
			} 
		}
	}
}