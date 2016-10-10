package com.beimin.eveapi.corporation.titles;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.corporation.TitlesParser;
import com.beimin.eveapi.response.corporation.TitlesResponse;
import org.junit.Ignore;

public class TitlesParserOnlineTest extends AbstractOnlineTest {

    @Test @Ignore("No data returned by the API")
    public void getResponse() throws Exception {
        final TitlesParser parser = new TitlesParser();
        final TitlesResponse response = parser.getResponse(getCorp());
        testResponse(response);
    }

}
