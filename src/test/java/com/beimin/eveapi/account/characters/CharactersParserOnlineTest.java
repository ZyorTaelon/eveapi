package com.beimin.eveapi.account.characters;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.account.CharactersParser;
import com.beimin.eveapi.response.account.CharactersResponse;

public class CharactersParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        // Not in faction
        addEmptyOK("getFactionName");
        addEmptyOK("getFactionID");
        // Not in alliance
        addEmptyOK("getAllianceName");
        addEmptyOK("getAllianceID");
        final CharactersParser parser = new CharactersParser();
        prepareParser(parser);

        final CharactersResponse response = parser.getResponse(getAccount());

        testResponse(response, 1);
    }

}
