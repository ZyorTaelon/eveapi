package com.beimin.eveapi.eve.character;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.eve.CharacterAffiliationParser;
import com.beimin.eveapi.response.eve.CharacterAffiliationResponse;

public class CharacterAffiliationParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        // Not in faction
        addEmptyOK("getFactionName");
        addEmptyOK("getFactionID");
        // Not in alliance
        addEmptyOK("getAllianceName");
        addEmptyOK("getAllianceID");
        final CharacterAffiliationParser parser = new CharacterAffiliationParser();
        prepareParser(parser);

        final CharacterAffiliationResponse response = parser.getResponse(getCharacterID());

        testResponse(response);
    }

}
