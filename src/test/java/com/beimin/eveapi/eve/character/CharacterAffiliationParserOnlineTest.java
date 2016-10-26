package com.beimin.eveapi.eve.character;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.eve.CharacterAffiliationParser;
import com.beimin.eveapi.response.eve.CharacterAffiliationResponse;

public class CharacterAffiliationParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        setAlias(CharacterAffiliationResponse.class, "characters", "items");
        // Not in faction
        allowEmpty("getFactionName");
        allowEmpty("getFactionID");
        // Not in alliance
        allowEmpty("getAllianceName");
        allowEmpty("getAllianceID");
        final CharacterAffiliationParser parser = new CharacterAffiliationParser();
        prepareParser(parser);

        final CharacterAffiliationResponse response = parser.getResponse(getCharacterID());

        testResponse(response);
    }

}
