package com.beimin.eveapi.map.kills;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Map;

import org.junit.Test;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.map.KillsParser;
import com.beimin.eveapi.response.map.KillsResponse;
import com.beimin.eveapi.utils.NoAuthParserTest;

public class KillsParserTest extends NoAuthParserTest {
    public KillsParserTest() {
        super(ApiPath.MAP, ApiPage.KILLS);
    }

    @Test
    public void getResponse() throws ApiException {
        final KillsParser parser = new KillsParser();
        final KillsResponse response = parser.getResponse();
        assertNotNull(response);
        final Map<Integer, Integer> shipKills = response.getShipKills();
        assertNotNull(shipKills);
        assertEquals(2603, shipKills.size());
        final Map<Integer, Integer> factionKills = response.getFactionKills();
        assertNotNull(factionKills);
        assertEquals(2603, factionKills.size());
        final Map<Integer, Integer> podKills = response.getPodKills();
        assertNotNull(podKills);
        assertEquals(2603, podKills.size());
        assertEquals(3, shipKills.get(30001001).longValue());
        assertEquals(203, factionKills.get(30001001).longValue());
        assertEquals(5, podKills.get(30001001).longValue());
        assertEquals(0, shipKills.get(30001039).longValue());
        assertEquals(40, factionKills.get(30001039).longValue());
        assertEquals(0, podKills.get(30001039).longValue());
    }
}
