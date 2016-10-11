package com.beimin.eveapi.corporation.outpost.list;

import org.junit.Ignore;
import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.corporation.OutpostListParser;
import com.beimin.eveapi.response.corporation.OutpostListResponse;

public class OutpostListParserOnlineTest extends AbstractOnlineTest {

    @Test @Ignore("No data returned by the API")
    public void getResponse() throws Exception {
        final OutpostListParser parser = new OutpostListParser();
        prepareParser(parser);

        final OutpostListResponse response = parser.getResponse(getCorp());

        testResponse(response);
    }

}
