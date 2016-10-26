package com.beimin.eveapi.character.sheet;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.pilot.CharacterSheetParser;
import com.beimin.eveapi.response.pilot.CharacterSheetResponse;

public class SheetParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        addIgnoreElement("row");
        addIgnoreElement("attributes");
        addEmptyOK("getAllianceID"); //not in alliance
        addNullOk("getAllianceName"); //not in alliance
        addEmptyOK("getCorporationTitles"); //no titles
        addEmptyOK("getCloneSkillPoints"); //always return zero now?
        addEmptyOK("getAttributeEnhancers"); //no attribute enhancers
        addEmptyOK("getFactionID"); //not in faction
        addEmptyOK("getFactionName"); //not in faction
        addEmptyOK("getHomeStationID"); //no home station
        addEmptyOK("getFreeSkillPoints"); //no free skill points
        final CharacterSheetParser parser = new CharacterSheetParser();
        prepareParser(parser);

        final CharacterSheetResponse response = parser.getResponse(getCharacter());

        testResponse(response, 1);
    }

}
