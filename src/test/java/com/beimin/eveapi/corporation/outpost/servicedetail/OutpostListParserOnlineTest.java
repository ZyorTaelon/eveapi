package com.beimin.eveapi.corporation.outpost.servicedetail;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.corporation.OutpostServiceDetailParser;
import com.beimin.eveapi.response.corporation.OutpostServiceDetailResponse;

public class OutpostListParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        final OutpostServiceDetailParser parser = new OutpostServiceDetailParser();
        final OutpostServiceDetailResponse response = parser.getResponse(getCorp());
        testResponse(response);
    }

}
