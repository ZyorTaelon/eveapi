package com.beimin.eveapi.eve.factwar.stats.top;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.utils.NoAuthParserTest;

public class FacWarTopStatsParserTest extends NoAuthParserTest {
	public FacWarTopStatsParserTest() {
		super(ApiPath.EVE, ApiPage.FACT_WAR_TOP_STATS);
	}

	@Test
	public void getResponse() throws ApiException {
		FacWarTopStatsParser parser = FacWarTopStatsParser.getInstance();
		FacWarTopStatsResponse facWarStats = parser.getResponse();
		assertKillerChar(1394672077, "Adolf Ehrnrooth", 17, facWarStats.getCharacterKillsYesterday());
		assertKillerChar(1780475402, "Loren Gallen", 46, facWarStats.getCharacterKillsLastWeek());
		assertKillerChar(1780475402, "Loren Gallen", 2598, facWarStats.getCharacterKillsTotal());
		assertVictoryPointerChar(1810868208, "Maik Zierra", 1504, facWarStats.getCharacterVictoryPointsYesterday());
		assertVictoryPointerChar(395923478, "sasawong", 13837, facWarStats.getCharacterVictoryPointsLastWeek());
		assertVictoryPointerChar(395923478, "sasawong", 699423, facWarStats.getCharacterVictoryPointsTotal());

		assertKillerCorp(207613888L, "Space Perverts and Forum Warriors United", 37, facWarStats.getCorporationKillsYesterday());
		assertKillerCorp(207613888L, "Space Perverts and Forum Warriors United", 135, facWarStats.getCorporationKillsLastWeek());
		assertKillerCorp(1000180L, "State Protectorate", 13568, facWarStats.getCorporationKillsTotal());
		assertVictoryPointerCorp(944307194L, "1st Praetorian Guard", 1852, facWarStats.getCorporationVictoryPointsYesterday());
		assertVictoryPointerCorp(637428501L, "Independent Corp.", 13837, facWarStats.getCorporationVictoryPointsLastWeek());
		assertVictoryPointerCorp(1000180L, "State Protectorate", 1673108, facWarStats.getCorporationVictoryPointsTotal());

		assertKillerFaction(500004, "Gallente Federation", 116, facWarStats.getFactionKillsYesterday());
		assertKillerFaction(500003, "Amarr Empire", 676, facWarStats.getFactionKillsLastWeek());
		assertKillerFaction(500004, "Gallente Federation", 78556, facWarStats.getFactionKillsTotal());
		assertVictoryPointerFaction(500003, "Amarr Empire", 6416, facWarStats.getFactionVictoryPointsYesterday());
		assertVictoryPointerFaction(500003, "Amarr Empire", 53943, facWarStats.getFactionVictoryPointsLastWeek());
		assertVictoryPointerFaction(500001, "Caldari State", 5730405, facWarStats.getFactionVictoryPointsTotal());
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