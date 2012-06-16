package com.beimin.eveapi.eve.factwar.stats.top;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.junit.Test;
import org.xml.sax.SAXException;

public class FacWarTopStatsParserTest {

	@Test
	public void facWarStats() throws IOException, SAXException {
		FacWarTopStatsParser parser = FacWarTopStatsParser.getInstance();
		InputStream input = FacWarTopStatsParserTest.class.getResourceAsStream("/eve/FacWarTopStats.xml");
		FacWarTopStatsResponse facWarStats = parser.getResponse(input);
		CharacterStats characterStats = facWarStats.getCharacterStats();
		List<CharacterKills> charKillsYesterday = characterStats.getKillsYesterday();
		assertKillerChar(1394672077, "Adolf Ehrnrooth", 17, charKillsYesterday);
		List<CharacterKills> charKillsLastWeek = characterStats.getKillsLastWeek();
		assertKillerChar(1780475402, "Loren Gallen", 46, charKillsLastWeek);
		List<CharacterKills> charKillsTotal = characterStats.getKillsTotal();
		assertKillerChar(1780475402, "Loren Gallen", 2598, charKillsTotal);
		List<CharacterVictoryPoints> charVictoryPointsYesterday = characterStats.getVictoryPointsYesterday();
		assertVictoryPointerChar(1810868208, "Maik Zierra", 1504, charVictoryPointsYesterday);
		List<CharacterVictoryPoints> charVictoryPointsLastWeek = characterStats.getVictoryPointsLastWeek();
		assertVictoryPointerChar(395923478, "sasawong", 13837, charVictoryPointsLastWeek);
		List<CharacterVictoryPoints> charVictoryPointsTotal = characterStats.getVictoryPointsTotal();
		assertVictoryPointerChar(395923478, "sasawong", 699423, charVictoryPointsTotal);
		
		CorporationStats corporationStats = facWarStats.getCorporationStats();
		List<CorporationKills> corpKillsYesterday = corporationStats.getKillsYesterday();
		assertKillerCorp(207613888L, "Space Perverts and Forum Warriors United", 37, corpKillsYesterday);
		List<CorporationKills> corpKillsLastWeek = corporationStats.getKillsLastWeek();
		assertKillerCorp(207613888L, "Space Perverts and Forum Warriors United", 135, corpKillsLastWeek);
		List<CorporationKills> corpKillsTotal = corporationStats.getKillsTotal();
		assertKillerCorp(1000180L, "State Protectorate", 13568, corpKillsTotal);
		List<CorporationVictoryPoints> corpVictoryPointsYesterday = corporationStats.getVictoryPointsYesterday();
		assertVictoryPointerCorp(944307194L, "1st Praetorian Guard", 1852, corpVictoryPointsYesterday);
		List<CorporationVictoryPoints> corpVictoryPointsLastWeek = corporationStats.getVictoryPointsLastWeek();
		assertVictoryPointerCorp(637428501L, "Independent Corp.", 13837, corpVictoryPointsLastWeek);
		List<CorporationVictoryPoints> corpVictoryPointsTotal = corporationStats.getVictoryPointsTotal();
		assertVictoryPointerCorp(1000180L, "State Protectorate", 1673108, corpVictoryPointsTotal);
		
		FactionStats factionStats = facWarStats.getFactionStats();
		List<FactionKills> facKillsYesterday = factionStats.getKillsYesterday();
		assertKillerFaction(500004, "Gallente Federation", 116, facKillsYesterday);
		List<FactionKills> facKillsLastWeek = factionStats.getKillsLastWeek();
		assertKillerFaction(500003, "Amarr Empire", 676, facKillsLastWeek);
		List<FactionKills> facKillsTotal = factionStats.getKillsTotal();
		assertKillerFaction(500004, "Gallente Federation", 78556, facKillsTotal);
		List<FactionVictoryPoints> facVictoryPointsYesterday = factionStats.getVictoryPointsYesterday();
		assertVictoryPointerFaction(500003, "Amarr Empire", 6416, facVictoryPointsYesterday);
		List<FactionVictoryPoints> facVictoryPointsLastWeek = factionStats.getVictoryPointsLastWeek();
		assertVictoryPointerFaction(500003, "Amarr Empire", 53943, facVictoryPointsLastWeek);
		List<FactionVictoryPoints> facVictoryPointsTotal = factionStats.getVictoryPointsTotal();
		assertVictoryPointerFaction(500001, "Caldari State", 5730405, facVictoryPointsTotal);
	}

	private void assertKillerChar(int characterID, String characterName, int kills, List<CharacterKills> killersList) {
		assertEquals(100, killersList.size());
		CharacterKills killer = killersList.iterator().next();
		assertEquals(characterID, killer.getCharacterID());
		assertEquals(characterName, killer.getCharacterName());
		assertEquals(kills, killer.getKills());
	}

	private void assertVictoryPointerChar(int characterID, String characterName, int victoryPoints, List<CharacterVictoryPoints> victoryPointersList) {
		assertEquals(100, victoryPointersList.size());
		CharacterVictoryPoints victoryPointer = victoryPointersList.iterator().next();
		assertEquals(characterID, victoryPointer.getCharacterID());
		assertEquals(characterName, victoryPointer.getCharacterName());
		assertEquals(victoryPoints, victoryPointer.getVictoryPoints());
	}

	private void assertKillerCorp(long corporationID, String corporationName, int kills, List<CorporationKills> killerList) {
		assertEquals(10, killerList.size());
		CorporationKills killer = killerList.iterator().next();
		assertEquals(corporationID, killer.getCorporationID());
		assertEquals(corporationName, killer.getCorporationName());
		assertEquals(kills, killer.getKills());
	}

	private void assertVictoryPointerCorp(long corporationID, String corporationName, int victoryPoints, List<CorporationVictoryPoints> victoryPointersList) {
		assertEquals(10, victoryPointersList.size());
		CorporationVictoryPoints victoryPointer = victoryPointersList.iterator().next();
		assertEquals(corporationID, victoryPointer.getCorporationID());
		assertEquals(corporationName, victoryPointer.getCorporationName());
		assertEquals(victoryPoints, victoryPointer.getVictoryPoints());
	}

	private void assertKillerFaction(int factionID, String factionName, int kills, List<FactionKills> killerList) {
		assertEquals(4, killerList.size());
		FactionKills killer = killerList.iterator().next();
		assertEquals(factionID, killer.getFactionID());
		assertEquals(factionName, killer.getFactionName());
		assertEquals(kills, killer.getKills());
	}

	private void assertVictoryPointerFaction(int factionID, String factionName, int victoryPoints, List<FactionVictoryPoints> victoryPointersList) {
		assertEquals(4, victoryPointersList.size());
		FactionVictoryPoints victoryPointer = victoryPointersList.iterator().next();
		assertEquals(factionID, victoryPointer.getFactionID());
		assertEquals(factionName, victoryPointer.getFactionName());
		assertEquals(victoryPoints, victoryPointer.getVictoryPoints());
	}
}