package com.beimin.eveapi.account.characters;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.account.CharactersParser;
import com.beimin.eveapi.response.account.CharactersResponse;

public class CharactersParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        setAlias(CharactersResponse.class, "characters", "items");
        // Not in faction
        allowEmpty("getFactionName");
        allowEmpty("getFactionID");
        // Not in alliance
        allowEmpty("getAllianceName");
        allowEmpty("getAllianceID");
        final CharactersParser parser = new CharactersParser();
        prepareParser(parser);

        final CharactersResponse response = parser.getResponse(getAccount());

        testResponse(response, 1);
    }

}
