package com.beimin.eveapi.character.standings;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.pilot.CharStandingsParser;
import com.beimin.eveapi.response.shared.StandingsResponse;

public class CharStandingsParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        final CharStandingsParser parser = new CharStandingsParser();
        final StandingsResponse response = parser.getResponse(getPilot());
        testResponse(response);
    }

}
