package com.beimin.eveapi.character.sheet;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.TestControl;
import com.beimin.eveapi.parser.pilot.CharacterSheetParser;
import com.beimin.eveapi.response.pilot.CharacterSheetResponse;
import static org.junit.Assume.assumeTrue;

public class SheetParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        assumeTrue("Other error", TestControl.runOther());
        final CharacterSheetParser parser = new CharacterSheetParser();
        prepareParser(parser);

        final CharacterSheetResponse response = parser.getResponse(getCharacter());

        testResponse(response, 1);
    }

}
