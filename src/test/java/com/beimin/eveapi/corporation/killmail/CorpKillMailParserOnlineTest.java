package com.beimin.eveapi.corporation.killmail;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.corporation.CorpKillMailParser;
import com.beimin.eveapi.response.shared.KillMailResponse;
import org.junit.Ignore;

public class CorpKillMailParserOnlineTest extends AbstractOnlineTest {

    @Test @Ignore("No data returned by the API")
    public void getResponse() throws Exception {
        addEmptyOK("getAllianceName");
        addEmptyOK("getCharacterName"); // Concord officers don't have a character name ;-)
        addEmptyOK("getFactionName");
        final CorpKillMailParser parser = new CorpKillMailParser();
        final KillMailResponse response = parser.getResponse(getCorp());
        testResponse(response);

        testFail("Does not test KillMail walking");
    }

}
