package com.beimin.eveapi.corporation.starbase.list;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.corporation.StarbaseListParser;
import com.beimin.eveapi.response.corporation.StarbaseListResponse;

public class StarbaseListParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        final StarbaseListParser parser = new StarbaseListParser();
        final StarbaseListResponse response = parser.getResponse(getCorp());
        testResponse(response);
    }

}
