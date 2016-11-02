package com.beimin.eveapi.corporation.factwar.stats;

import static org.junit.Assume.assumeTrue;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.TestControl;
import com.beimin.eveapi.parser.corporation.CorpFacWarStatsParser;
import com.beimin.eveapi.response.shared.FacWarStatsResponse;

public class CorpFacWarStatsParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        assumeTrue("API Error", TestControl.runApiError());
        final CorpFacWarStatsParser parser = new CorpFacWarStatsParser();
        prepareParser(parser);

        final FacWarStatsResponse facWarStatsResponse = parser.getResponse(getCorp());

        testResponse(facWarStatsResponse);
    }

}
