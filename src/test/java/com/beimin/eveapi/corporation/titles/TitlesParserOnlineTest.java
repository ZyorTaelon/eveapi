package com.beimin.eveapi.corporation.titles;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.corporation.TitlesParser;
import com.beimin.eveapi.response.corporation.TitlesResponse;

public class TitlesParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        setAlias(TitlesResponse.class, "titles", "items");
        final TitlesParser parser = new TitlesParser();
        prepareParser(parser);

        final TitlesResponse response = parser.getResponse(getCorp());

        testResponse(response);
    }

}
