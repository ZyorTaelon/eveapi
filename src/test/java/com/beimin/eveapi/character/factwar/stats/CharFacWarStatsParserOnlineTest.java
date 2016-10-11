package com.beimin.eveapi.character.factwar.stats;

import org.junit.Ignore;
import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.pilot.CharFacWarStatsParser;
import com.beimin.eveapi.response.shared.FacWarStatsResponse;

public class CharFacWarStatsParserOnlineTest extends AbstractOnlineTest {

    @Test @Ignore("API Error")
    public void getResponse() throws Exception {
        final CharFacWarStatsParser parser = new CharFacWarStatsParser();
        prepareParser(parser);

        final FacWarStatsResponse facWarStatsResponse = parser.getResponse(getCharacter());

        testResponse(facWarStatsResponse);
    }

}
