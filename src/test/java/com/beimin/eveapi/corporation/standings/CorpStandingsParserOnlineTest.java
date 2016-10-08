package com.beimin.eveapi.corporation.standings;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.corporation.StandingsParser;
import com.beimin.eveapi.response.shared.StandingsResponse;

public class CorpStandingsParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        final StandingsParser parser = new StandingsParser();
        final StandingsResponse response = parser.getResponse(getCorp());
        testResponse(response);
    }

}
