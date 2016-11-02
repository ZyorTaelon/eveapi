package com.beimin.eveapi.map.factwar.systems;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.model.map.FacWarSystem;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.map.FacWarSystemsParser;
import com.beimin.eveapi.response.map.FacWarSystemsResponse;
import com.beimin.eveapi.utils.NoAuthParserTest;

public class FacWarSystemsParserTest extends NoAuthParserTest {
    public FacWarSystemsParserTest() {
        super(ApiPath.MAP, ApiPage.FACTION_WAR_SYSTEMS);
    }

    @Test
    public void getResponse() throws ApiException {
        final FacWarSystemsParser parser = new FacWarSystemsParser();
        final FacWarSystemsResponse response = parser.getResponse();
        final List<FacWarSystem> systems = response.getAll();
        assertEquals(171, systems.size());
        final Iterator<FacWarSystem> iterator = systems.iterator();
        FacWarSystem facWarSystem = iterator.next();
        assertEquals(30002094, facWarSystem.getSolarSystemID());
        assertEquals("Ebolfer", facWarSystem.getSolarSystemName());
        assertEquals(0, facWarSystem.getOccupyingFactionID());
        assertEquals(500002, facWarSystem.getOwningFactionID());
        assertEquals("", facWarSystem.getOccupyingFactionName());
        assertEquals("Minmatar Republic", facWarSystem.getOwningFactionName());
        assertFalse("This system shouldn't be contested.", facWarSystem.isContested());
        assertEquals(0, facWarSystem.getVictoryPoints());
        assertEquals(3000, facWarSystem.getVictoryPointThreshold());
        for (int i = 0; i < 123; i++) {
            iterator.next();
        }
        facWarSystem = iterator.next();
        assertEquals(30045344, facWarSystem.getSolarSystemID());
        assertEquals("Nennamaila", facWarSystem.getSolarSystemName());
        assertEquals(500004, facWarSystem.getOccupyingFactionID());
        assertEquals(500001, facWarSystem.getOwningFactionID());
        assertEquals("Gallente Federation", facWarSystem.getOccupyingFactionName());
        assertEquals("Caldari State", facWarSystem.getOwningFactionName());
        assertTrue("This system should be contested.", facWarSystem.isContested());
        assertEquals(1420, facWarSystem.getVictoryPoints());
        assertEquals(3000, facWarSystem.getVictoryPointThreshold());
    }
}
