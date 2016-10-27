package com.beimin.eveapi.map.kills;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.map.KillsParser;
import com.beimin.eveapi.response.map.KillsResponse;

public class KillsParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        setAlias(KillsResponse.class, "solarSystems", "items");
        ignoreClassField(KillsResponse.class, "shipKills");
        ignoreClassField(KillsResponse.class, "factionKills");
        ignoreClassField(KillsResponse.class, "podKills");
        ignoreXmlField("datatime");
        allowEmpty("getShipKills->MapValue"); // No ship kills
        allowEmpty("getPodKills->MapValue"); // No pod kills
        final KillsParser parser = new KillsParser();
        prepareParser(parser);

        final KillsResponse response = parser.getResponse();

        testResponse(response);
    }

}
