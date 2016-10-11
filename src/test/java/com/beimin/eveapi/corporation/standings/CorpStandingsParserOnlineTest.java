package com.beimin.eveapi.corporation.standings;

import org.junit.Ignore;
import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.corporation.CorpStandingsParser;
import com.beimin.eveapi.response.shared.StandingsResponse;

public class CorpStandingsParserOnlineTest extends AbstractOnlineTest {

    @Test @Ignore("New fields test not working")
    public void getResponse() throws Exception {
        final CorpStandingsParser parser = new CorpStandingsParser();
        prepareParser(parser);

        final StandingsResponse response = parser.getResponse(getCorp());

        testResponse(response);
    }

}
