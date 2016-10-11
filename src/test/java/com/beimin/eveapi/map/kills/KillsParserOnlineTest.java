package com.beimin.eveapi.map.kills;

import org.junit.Ignore;
import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.map.KillsParser;
import com.beimin.eveapi.response.map.KillsResponse;

public class KillsParserOnlineTest extends AbstractOnlineTest {

    @Test @Ignore("No data returned by the API")
    public void getResponse() throws Exception {
        addEmptyOK("getShipKills->MapValue"); // No ship kills
        addEmptyOK("getPodKills->MapValue"); // No pod kills
        final KillsParser parser = new KillsParser();
        prepareParser(parser);

        final KillsResponse response = parser.getResponse();

        testResponse(response);
    }

}
