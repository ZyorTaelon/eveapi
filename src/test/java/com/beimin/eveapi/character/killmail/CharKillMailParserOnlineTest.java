package com.beimin.eveapi.character.killmail;

import org.junit.Ignore;
import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.pilot.CharKillMailParser;
import com.beimin.eveapi.response.shared.KillMailResponse;

public class CharKillMailParserOnlineTest extends AbstractOnlineTest {

    @Test @Ignore("No data returned by the API")
    public void getResponse() throws Exception {
        addEmptyOK("getAllianceName");
        addEmptyOK("getCharacterName"); // Concord officers don't have a character name ;-)
        addEmptyOK("getFactionName");
        final CharKillMailParser parser = new CharKillMailParser();
        prepareParser(parser);

        final KillMailResponse response = parser.getResponse(getCharacter());

        testResponse(response);
        testFail("Does not test KillMail walking");
    }

}
