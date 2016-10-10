package com.beimin.eveapi.corporation.standings;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.corporation.CorpStandingsParser;
import com.beimin.eveapi.response.shared.StandingsResponse;
import org.junit.Ignore;

public class CorpStandingsParserOnlineTest extends AbstractOnlineTest {

    @Test @Ignore("New fields test not working")
    public void getResponse() throws Exception {
        final CorpStandingsParser parser = new CorpStandingsParser();
        final StandingsResponse response = parser.getResponse(getCorp());
        testResponse(response);
    }

}
