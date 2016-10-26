package com.beimin.eveapi.character.blueprints;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.TestControl;
import com.beimin.eveapi.parser.pilot.CharBlueprintsParser;
import com.beimin.eveapi.response.shared.BlueprintsResponse;
import static org.junit.Assume.assumeTrue;

public class CharBlueprintsParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void blueprintsParser() throws Exception {
        assumeTrue("No data returned by the API", TestControl.runNoData());
        addEmptyOK("getTimeEfficiency"); //Zero is a valid value
        addEmptyOK("getMaterialEfficiency"); //Zero is a valid value
        final CharBlueprintsParser parser = new CharBlueprintsParser();
        prepareParser(parser);

        final BlueprintsResponse response = parser.getResponse(getCharacter());

        testResponse(response);
    }

}
