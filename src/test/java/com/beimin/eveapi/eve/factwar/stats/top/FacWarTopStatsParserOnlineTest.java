package com.beimin.eveapi.eve.factwar.stats.top;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.eve.FacWarTopStatsParser;
import com.beimin.eveapi.response.eve.FacWarTopStatsResponse;

public class FacWarTopStatsParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        ignoreXmlField("corporations");
        ignoreXmlField("characters");
        ignoreXmlField("factions");
        // Always include one respose with one row with getCharacterID="0" and getCharacterName=""
        allowEmpty("getCharacterID");
        allowEmpty("getCharacterName");
        // Always include one respose with one row with getCorporationID="0" and getCharacterName=""
        allowEmpty("getCorporationID");
        allowEmpty("getCharacterName");
        final FacWarTopStatsParser parser = new FacWarTopStatsParser();
        prepareParser(parser, true);

        final FacWarTopStatsResponse response = parser.getResponse();

        testResponse(response);
    }

}
