package com.beimin.eveapi.character.standings;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.pilot.CharStandingsParser;
import com.beimin.eveapi.response.shared.StandingsResponse;
import org.junit.Ignore;

public class CharStandingsParserOnlineTest extends AbstractOnlineTest {

    @Test @Ignore("New fields test not working")
    public void getResponse() throws Exception {
        final CharStandingsParser parser = new CharStandingsParser();
        final StandingsResponse response = parser.getResponse(getPilot());
        testResponse(response);
    }

}
