package com.beimin.eveapi.corporation.outpost.servicedetail;

import org.junit.Ignore;
import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.corporation.OutpostServiceDetailParser;
import com.beimin.eveapi.response.corporation.OutpostServiceDetailResponse;

public class OutpostListParserOnlineTest extends AbstractOnlineTest {

    @Test @Ignore("No data returned by the API")
    public void getResponse() throws Exception {
        final OutpostServiceDetailParser parser = new OutpostServiceDetailParser();
        prepareParser(parser);

        final OutpostServiceDetailResponse response = parser.getResponse(getCorp());

        testResponse(response);
    }

}
