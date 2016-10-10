package com.beimin.eveapi.corporation.factwar.stats;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.corporation.CorpFacWarStatsParser;
import com.beimin.eveapi.response.shared.FacWarStatsResponse;

public class CorpFacWarStatsParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        final CorpFacWarStatsParser parser = new CorpFacWarStatsParser();
        final FacWarStatsResponse facWarStatsResponse = parser.getResponse(getCorp());
        testResponse(facWarStatsResponse);
    }

}