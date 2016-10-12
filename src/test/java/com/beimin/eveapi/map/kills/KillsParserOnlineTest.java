package com.beimin.eveapi.map.kills;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.TestControl;
import com.beimin.eveapi.parser.map.KillsParser;
import com.beimin.eveapi.response.map.KillsResponse;
import static org.junit.Assume.assumeTrue;

public class KillsParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        assumeTrue("No data returned by the API", TestControl.runNoData());
        addEmptyOK("getShipKills->MapValue"); // No ship kills
        addEmptyOK("getPodKills->MapValue"); // No pod kills
        final KillsParser parser = new KillsParser();
        prepareParser(parser);

        final KillsResponse response = parser.getResponse();

        testResponse(response);
    }

}
