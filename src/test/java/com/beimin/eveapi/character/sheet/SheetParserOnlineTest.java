package com.beimin.eveapi.character.sheet;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.pilot.CharacterSheetParser;
import com.beimin.eveapi.response.pilot.CharacterSheetResponse;

public class SheetParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        setAlias(CharacterSheetResponse.class, "dob", "dateOfBirth");
        ignoreXmlField("attributes");
        ignoreXmlField("certificates");
        allowEmpty("getCloneName");
        allowEmpty("getAllianceID"); //not in alliance
        allowNull("getAllianceName"); //not in alliance
        allowEmpty("getCorporationTitles"); //no titles
        allowEmpty("getCloneSkillPoints"); //always return zero now?
        allowEmpty("getAttributeEnhancers"); //no attribute enhancers
        allowEmpty("getFactionID"); //not in faction
        allowEmpty("getFactionName"); //not in faction
        allowEmpty("getHomeStationID"); //no home station
        allowEmpty("getFreeSkillPoints"); //no free skill points
        final CharacterSheetParser parser = new CharacterSheetParser();
        prepareParser(parser);

        final CharacterSheetResponse response = parser.getResponse(getCharacter());

        testResponse(response, 1);
    }

}
