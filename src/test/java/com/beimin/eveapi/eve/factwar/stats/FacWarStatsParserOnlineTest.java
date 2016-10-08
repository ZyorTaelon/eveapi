package com.beimin.eveapi.eve.factwar.stats;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.eve.FacWarStatsParser;
import com.beimin.eveapi.response.eve.FacWarStatsResponse;

public class FacWarStatsParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        final FacWarStatsParser parser = new FacWarStatsParser();
        final FacWarStatsResponse response = parser.getResponse();
        testResponse(response);
    }

}
