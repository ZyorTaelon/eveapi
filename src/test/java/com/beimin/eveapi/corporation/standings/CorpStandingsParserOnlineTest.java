package com.beimin.eveapi.corporation.standings;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.TestControl;
import com.beimin.eveapi.parser.corporation.CorpStandingsParser;
import com.beimin.eveapi.response.shared.StandingsResponse;
import static org.junit.Assume.assumeTrue;

public class CorpStandingsParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        assumeTrue("Other error", TestControl.runOther());
        final CorpStandingsParser parser = new CorpStandingsParser();
        prepareParser(parser);

        final StandingsResponse response = parser.getResponse(getCorp());

        testResponse(response);
    }

}
