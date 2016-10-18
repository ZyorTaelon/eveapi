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
        assumeTrue("Bug: Missing fields", TestControl.runBug());
        addEmptyOK("getAllianceID"); //not in alliance
        addNullOk("getAllianceName"); //not in alliance
        addEmptyOK("getCorporationTitles"); //no titles
        addEmptyOK("getCloneSkillPoints"); //always return zero now?
        addEmptyOK("getAttributeEnhancers"); //no attribute enhancers
        final CharacterSheetParser parser = new CharacterSheetParser();
        prepareParser(parser);

        final CharacterSheetResponse response = parser.getResponse(getCharacter());

        testResponse(response, 1);
    }

}
