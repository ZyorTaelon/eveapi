package com.beimin.eveapi.corporation.killmail;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.corporation.KillMailParser;
import com.beimin.eveapi.parser.shared.AbstractKillMailParser;
import com.beimin.eveapi.response.shared.KillMailResponse;

public class CorpKillMailParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        addEmptyOK("getAllianceName");
        addEmptyOK("getCharacterName"); // Concord officers don't have a character name ;-)
        addEmptyOK("getFactionName");
        final AbstractKillMailParser parser = new KillMailParser();
        final KillMailResponse response = parser.getResponse(getCorp());
        testResponse(response);

        testFail("Does not test KillMail walking");
    }

}
