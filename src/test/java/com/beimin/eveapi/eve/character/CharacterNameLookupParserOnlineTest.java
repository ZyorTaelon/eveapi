package com.beimin.eveapi.eve.character;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.eve.CharacterLookupParser;
import com.beimin.eveapi.response.eve.CharacterLookupResponse;

public class CharacterNameLookupParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        setAlias(CharacterLookupResponse.class, "characters", "items");
        final CharacterLookupParser parser = CharacterLookupParser.getId2NameInstance();
        prepareParser(parser);

        final CharacterLookupResponse response = parser.getResponse(getCharacterID());

        testResponse(response);
    }

}
