package com.beimin.eveapi.character.killmail;

import static org.junit.Assume.assumeTrue;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.TestControl;
import com.beimin.eveapi.parser.character.CharKillMailParser;
import com.beimin.eveapi.response.shared.KillMailResponse;

public class CharKillMailParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        setAlias(KillMailResponse.class, "kills", "items");
        allowEmpty("getAllianceName");
        allowEmpty("getCharacterName"); // Concord officers don't have a character name ;-)
        allowEmpty("getFactionName");
        final CharKillMailParser parser = new CharKillMailParser();
        prepareParser(parser);

        final KillMailResponse response = parser.getResponse(getCharacter());

        testResponse(response);
    }

    @Test
    public void getResponseWalking() throws Exception {
        assumeTrue("Test not completed", TestControl.runTestIncomplete());
        testFail("Does not test KillMail walking");
    }

}
