package com.beimin.eveapi.character.factwar.stats;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.pilot.FacWarStatsParser;
import com.beimin.eveapi.response.shared.FacWarStatsResponse;

public class CharFacWarStatsParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        final FacWarStatsParser parser = new FacWarStatsParser();
        final FacWarStatsResponse facWarStatsResponse = parser.getResponse(getPilot());
        testResponse(facWarStatsResponse);
    }

}