package com.beimin.eveapi.eve.factwar.stats.top;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.model.eve.CharacterKills;
import com.beimin.eveapi.model.eve.CharacterVictoryPoints;
import com.beimin.eveapi.model.eve.CorporationKills;
import com.beimin.eveapi.model.eve.CorporationVictoryPoints;
import com.beimin.eveapi.model.eve.FactionKills;
import com.beimin.eveapi.model.eve.FactionVictoryPoints;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.eve.FacWarTopStatsParser;
import com.beimin.eveapi.response.eve.FacWarTopStatsResponse;
import com.beimin.eveapi.utils.NoAuthParserTest;

public class FacWarTopStatsParserTest extends NoAuthParserTest {
    public FacWarTopStatsParserTest() {
        super(ApiPath.EVE, ApiPage.FACT_WAR_TOP_STATS);
    }

    @Test
    public void getResponse() throws ApiException {
        final FacWarTopStatsParser parser = new FacWarTopStatsParser();
        final FacWarTopStatsResponse facWarStats = parser.getResponse();
        assertKillerChar(1394672077, "Adolf Ehrnrooth", 17, facWarStats.getCharactersKillsYesterday());
        assertKillerChar(1780475402, "Loren Gallen", 46, facWarStats.getCharactersKillsLastWeek());
        assertKillerChar(1780475402, "Loren Gallen", 2598, facWarStats.getCharactersKillsTotal());
        assertVictoryPointerChar(1810868208, "Maik Zierra", 1504, facWarStats.getCharactersVictoryPointsYesterday());
        assertVictoryPointerChar(395923478, "sasawong", 13837, facWarStats.getCharactersVictoryPointsLastWeek());
        assertVictoryPointerChar(395923478, "sasawong", 699423, facWarStats.getCharactersVictoryPointsTotal());

        assertKillerCorp(207613888L, "Space Perverts and Forum Warriors United", 37, facWarStats.getCorporationsKillsYesterday());
        assertKillerCorp(207613888L, "Space Perverts and Forum Warriors United", 135, facWarStats.getCorporationsKillsLastWeek());
        assertKillerCorp(1000180L, "State Protectorate", 13568, facWarStats.getCorporationsKillsTotal());
        assertVictoryPointerCorp(944307194L, "1st Praetorian Guard", 1852, facWarStats.getCorporationsVictoryPointsYesterday());
        assertVictoryPointerCorp(637428501L, "Independent Corp.", 13837, facWarStats.getCorporationsVictoryPointsLastWeek());
        assertVictoryPointerCorp(1000180L, "State Protectorate", 1673108, facWarStats.getCorporationsVictoryPointsTotal());

        assertKillerFaction(500004, "Gallente Federation", 116, facWarStats.getFactionsKillsYesterday());
        assertKillerFaction(500003, "Amarr Empire", 676, facWarStats.getFactionsKillsLastWeek());
        assertKillerFaction(500004, "Gallente Federation", 78556, facWarStats.getFactionsKillsTotal());
        assertVictoryPointerFaction(500003, "Amarr Empire", 6416, facWarStats.getFactionsVictoryPointsYesterday());
        assertVictoryPointerFaction(500003, "Amarr Empire", 53943, facWarStats.getFactionsVictoryPointsLastWeek());
        assertVictoryPointerFaction(500001, "Caldari State", 5730405, facWarStats.getFactionsVictoryPointsTotal());
    }

    private void assertKillerChar(final int characterID, final String characterName, final int kills, final List<CharacterKills> killersList) {
        assertEquals(100, killersList.size());
        final CharacterKills killer = killersList.iterator().next();
        assertEquals(characterID, killer.getCharacterID());
        assertEquals(characterName, killer.getCharacterName());
        assertEquals(kills, killer.getKills());
    }

    private void assertVictoryPointerChar(final int characterID, final String characterName, final int victoryPoints, final List<CharacterVictoryPoints> victoryPointersList) {
        assertEquals(100, victoryPointersList.size());
        final CharacterVictoryPoints victoryPointer = victoryPointersList.iterator().next();
        assertEquals(characterID, victoryPointer.getCharacterID());
        assertEquals(characterName, victoryPointer.getCharacterName());
        assertEquals(victoryPoints, victoryPointer.getVictoryPoints());
    }

    private void assertKillerCorp(final long corporationID, final String corporationName, final int kills, final List<CorporationKills> killerList) {
        assertEquals(10, killerList.size());
        final CorporationKills killer = killerList.iterator().next();
        assertEquals(corporationID, killer.getCorporationID());
        assertEquals(corporationName, killer.getCorporationName());
        assertEquals(kills, killer.getKills());
    }

    private void assertVictoryPointerCorp(final long corporationID, final String corporationName, final int victoryPoints, final List<CorporationVictoryPoints> victoryPointersList) {
        assertEquals(10, victoryPointersList.size());
        final CorporationVictoryPoints victoryPointer = victoryPointersList.iterator().next();
        assertEquals(corporationID, victoryPointer.getCorporationID());
        assertEquals(corporationName, victoryPointer.getCorporationName());
        assertEquals(victoryPoints, victoryPointer.getVictoryPoints());
    }

    private void assertKillerFaction(final int factionID, final String factionName, final int kills, final List<FactionKills> killerList) {
        assertEquals(4, killerList.size());
        final FactionKills killer = killerList.iterator().next();
        assertEquals(factionID, killer.getFactionID());
        assertEquals(factionName, killer.getFactionName());
        assertEquals(kills, killer.getKills());
    }

    private void assertVictoryPointerFaction(final int factionID, final String factionName, final int victoryPoints, final List<FactionVictoryPoints> victoryPointersList) {
        assertEquals(4, victoryPointersList.size());
        final FactionVictoryPoints victoryPointer = victoryPointersList.iterator().next();
        assertEquals(factionID, victoryPointer.getFactionID());
        assertEquals(factionName, victoryPointer.getFactionName());
        assertEquals(victoryPoints, victoryPointer.getVictoryPoints());
    }
}

