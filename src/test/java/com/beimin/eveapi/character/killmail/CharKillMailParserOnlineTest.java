package com.beimin.eveapi.character.killmail;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.TestControl;
import com.beimin.eveapi.parser.pilot.CharKillMailParser;
import com.beimin.eveapi.response.shared.KillMailResponse;
import static org.junit.Assume.assumeTrue;

public class CharKillMailParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        assumeTrue("No data returned by the API", TestControl.runNoData());
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
