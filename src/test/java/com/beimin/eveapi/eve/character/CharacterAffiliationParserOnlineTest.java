package com.beimin.eveapi.eve.character;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.eve.CharacterAffiliationParser;
import com.beimin.eveapi.response.eve.CharacterAffiliationResponse;

public class CharacterAffiliationParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        addEmptyOK("getFactionName"); // Not in faction
        addEmptyOK("getAllianceName"); // Not in alliance
        final CharacterAffiliationParser parser = new CharacterAffiliationParser();
        final CharacterAffiliationResponse response = parser.getResponse(getCharacterID());
        testResponse(response);
    }

}