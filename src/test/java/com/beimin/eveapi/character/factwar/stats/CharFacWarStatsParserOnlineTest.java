package com.beimin.eveapi.character.factwar.stats;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.TestControl;
import com.beimin.eveapi.parser.pilot.CharFacWarStatsParser;
import com.beimin.eveapi.response.shared.FacWarStatsResponse;
import static org.junit.Assume.assumeTrue;

public class CharFacWarStatsParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        assumeTrue("API Error", TestControl.runApiError());
        final CharFacWarStatsParser parser = new CharFacWarStatsParser();
        prepareParser(parser);

        final FacWarStatsResponse facWarStatsResponse = parser.getResponse(getCharacter());

        testResponse(facWarStatsResponse);
    }

}
