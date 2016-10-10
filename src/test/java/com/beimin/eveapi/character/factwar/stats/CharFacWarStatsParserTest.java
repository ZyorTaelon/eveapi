package com.beimin.eveapi.character.factwar.stats;


import org.junit.Test;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.pilot.CharFacWarStatsParser;
import com.beimin.eveapi.response.shared.FacWarStatsResponse;
import com.beimin.eveapi.utils.FullAuthParserTest;
import static org.junit.Assert.assertEquals;
import static com.beimin.eveapi.utils.Assert.assertDate;

public class CharFacWarStatsParserTest extends FullAuthParserTest {
    public CharFacWarStatsParserTest() {
        super(ApiPath.CHARACTER, ApiPage.FACT_WAR_STATS);
    }

    @Test
    public void getResponse() throws ApiException {
        final CharFacWarStatsParser parser = new CharFacWarStatsParser();
        final FacWarStatsResponse facWarStats = parser.getResponse(auth);
        assertEquals(500001, facWarStats.getFactionID());
        assertEquals("Caldari State", facWarStats.getFactionName());
        assertDate(2008, 6, 10, 22, 10, 0, facWarStats.getEnlisted());
        assertEquals(4, facWarStats.getCurrentRank());
        assertEquals(4, facWarStats.getHighestRank());
        assertEquals(0, facWarStats.getKillsYesterday());
        assertEquals(0, facWarStats.getKillsLastWeek());
        assertEquals(0, facWarStats.getKillsTotal());
        assertEquals(0, facWarStats.getVictoryPointsYesterday());
        assertEquals(1044, facWarStats.getVictoryPointsLastWeek());
        assertEquals(0, facWarStats.getVictoryPointsTotal());
    }
}

