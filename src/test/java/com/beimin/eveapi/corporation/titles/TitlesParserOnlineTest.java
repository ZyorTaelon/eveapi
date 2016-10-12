package com.beimin.eveapi.corporation.titles;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.TestControl;
import com.beimin.eveapi.parser.corporation.TitlesParser;
import com.beimin.eveapi.response.corporation.TitlesResponse;
import static org.junit.Assume.assumeTrue;

public class TitlesParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        assumeTrue("No data returned by the API", TestControl.runNoData());
        final TitlesParser parser = new TitlesParser();
        prepareParser(parser);

        final TitlesResponse response = parser.getResponse(getCorp());

        testResponse(response);
    }

}
