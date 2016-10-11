package com.beimin.eveapi.character.blueprints;

import org.junit.Ignore;
import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.pilot.CharBlueprintsParser;
import com.beimin.eveapi.response.shared.BlueprintsResponse;

public class CharBlueprintsParserOnlineTest extends AbstractOnlineTest {

    @Test @Ignore("No data returned by the API")
    public void blueprintsParser() throws Exception {
        final CharBlueprintsParser parser = new CharBlueprintsParser();
        prepareParser(parser);

        final BlueprintsResponse response = parser.getResponse(getCharacter());

        testResponse(response);
    }

}
