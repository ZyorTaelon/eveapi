package com.beimin.eveapi.character.blueprints;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.pilot.BlueprintsParser;
import com.beimin.eveapi.response.shared.BlueprintsResponse;

public class CharBlueprintsParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void blueprintsParser() throws Exception {
        final BlueprintsParser parser = new BlueprintsParser();
        final BlueprintsResponse response = parser.getResponse(getPilot());
        testResponse(response);
    }

}