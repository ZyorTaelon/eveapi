package com.beimin.eveapi.eve.alliancelist;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.TestControl;
import com.beimin.eveapi.parser.eve.AllianceListParser;
import com.beimin.eveapi.response.eve.AllianceListResponse;
import static org.junit.Assume.assumeTrue;

public class AllianceListParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        assumeTrue("No data returned by the API", TestControl.runNoData());
        final AllianceListParser parser = new AllianceListParser();
        prepareParser(parser);

        final AllianceListResponse response = parser.getResponse();

        testResponse(response);
    }

}
