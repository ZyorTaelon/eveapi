package com.beimin.eveapi.corporation.outpost.servicedetail;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.TestControl;
import com.beimin.eveapi.parser.corporation.OutpostServiceDetailParser;
import com.beimin.eveapi.response.corporation.OutpostServiceDetailResponse;
import static org.junit.Assume.assumeTrue;

public class OutpostListParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        assumeTrue("No data returned by the API", TestControl.runNoData());
        final OutpostServiceDetailParser parser = new OutpostServiceDetailParser();
        prepareParser(parser);

        final OutpostServiceDetailResponse response = parser.getResponse(getCorp());

        testResponse(response);
    }

}
