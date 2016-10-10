package com.beimin.eveapi.character.sheet;

import org.junit.Ignore;
import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.pilot.CharacterSheetParser;
import com.beimin.eveapi.response.pilot.CharacterSheetResponse;

public class SheetParserOnlineTest extends AbstractOnlineTest {

    @Test @Ignore ("com.beimin.eveapi.response.pilot.CharacterSheetResponse.certificates removed from the API")
    public void getResponse() throws Exception {
        final CharacterSheetParser parser = new CharacterSheetParser();
        prepareParser(parser);

        final CharacterSheetResponse response = parser.getResponse(getCharacter());

        testResponse(response, 1);
    }

}
