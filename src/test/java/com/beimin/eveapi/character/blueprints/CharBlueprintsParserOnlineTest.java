package com.beimin.eveapi.character.blueprints;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.pilot.CharBlueprintsParser;
import com.beimin.eveapi.response.shared.BlueprintsResponse;

public class CharBlueprintsParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void blueprintsParser() throws Exception {
        setAlias(BlueprintsResponse.class, "blueprints", "items");
        allowEmpty("getTimeEfficiency"); //Zero is a valid value
        allowEmpty("getMaterialEfficiency"); //Zero is a valid value
        final CharBlueprintsParser parser = new CharBlueprintsParser();
        prepareParser(parser);

        final BlueprintsResponse response = parser.getResponse(getCharacter());

        testResponse(response);
    }

}
