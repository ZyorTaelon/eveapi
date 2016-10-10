package com.beimin.eveapi.character.sheet;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.pilot.CharacterSheetParser;
import com.beimin.eveapi.response.pilot.CharacterSheetResponse;
import org.junit.Ignore;

public class SheetParserOnlineTest extends AbstractOnlineTest {

    @Test @Ignore ("com.beimin.eveapi.response.pilot.CharacterSheetResponse.certificates removed from the API")
    public void getResponse() throws Exception {
        final CharacterSheetParser parser = new CharacterSheetParser();
        final CharacterSheetResponse response = parser.getResponse(getPilot());
        testResponse(response, 1);
    }

}
