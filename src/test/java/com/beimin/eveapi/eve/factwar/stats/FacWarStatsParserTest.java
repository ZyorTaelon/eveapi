package com.beimin.eveapi.eve.factwar.stats;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.model.eve.FactionStats;
import com.beimin.eveapi.model.eve.FactionWar;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.eve.FacWarStatsParser;
import com.beimin.eveapi.response.eve.FacWarStatsResponse;
import com.beimin.eveapi.utils.NoAuthParserTest;

public class FacWarStatsParserTest extends NoAuthParserTest {
    public FacWarStatsParserTest() {
        super(ApiPath.EVE, ApiPage.FACT_WAR_STATS);
    }

    @Test
    public void getResponse() throws ApiException {
        final FacWarStatsParser parser = new FacWarStatsParser();
        final FacWarStatsResponse facWarStats = parser.getResponse();
        assertEquals(677, facWarStats.getKillsYesterday());
        assertEquals(3246, facWarStats.getKillsLastWeek());
        assertEquals(232772, facWarStats.getKillsTotal());
        assertEquals(55087, facWarStats.getVictoryPointsYesterday());
        assertEquals(414049, facWarStats.getVictoryPointsLastWeek());
        assertEquals(44045189, facWarStats.getVictoryPointsTotal());
        final List<FactionStats> factions = facWarStats.getFactions();
        assertEquals(4, factions.size());
        final FactionStats factionStats = factions.iterator().next();
        assertEquals(500001, factionStats.getFactionID());
        assertEquals("Caldari State", factionStats.getFactionName());
        assertEquals(5324, factionStats.getPilots());
        assertEquals(61, factionStats.getSystemsControlled());
        assertEquals(115, factionStats.getKillsYesterday());
        assertEquals(627, factionStats.getKillsLastWeek());
        assertEquals(59239, factionStats.getKillsTotal());
        assertEquals(9934, factionStats.getVictoryPointsYesterday());
        assertEquals(64548, factionStats.getVictoryPointsLastWeek());
        assertEquals(4506493, factionStats.getVictoryPointsTotal());
        final List<FactionWar> wars = facWarStats.getWars();
        assertEquals(8, wars.size());
        final FactionWar factionWar = wars.iterator().next();
        assertEquals(500001, factionWar.getFactionID());
        assertEquals("Caldari State", factionWar.getFactionName());
        assertEquals(500002, factionWar.getAgainstID());
        assertEquals("Minmatar Republic", factionWar.getAgainstName());
    }
}
