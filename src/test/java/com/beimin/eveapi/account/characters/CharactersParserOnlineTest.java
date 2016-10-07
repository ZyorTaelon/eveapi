package com.beimin.eveapi.account.characters;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.account.CharactersParser;
import com.beimin.eveapi.response.account.CharactersResponse;

public class CharactersParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        addEmptyOK("getFactionName"); // Not in faction
        addEmptyOK("getAllianceName"); // Not in alliance
        final CharactersParser parser = new CharactersParser();
        final CharactersResponse response = parser.getResponse(getAccount());
        testResponse(response, 1);
    }

}