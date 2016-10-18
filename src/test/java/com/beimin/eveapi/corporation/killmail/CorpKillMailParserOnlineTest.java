package com.beimin.eveapi.corporation.killmail;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.TestControl;
import com.beimin.eveapi.parser.corporation.CorpKillMailParser;
import com.beimin.eveapi.response.shared.KillMailResponse;
import static org.junit.Assume.assumeTrue;

public class CorpKillMailParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        assumeTrue("No data returned by the API", TestControl.runNoData());
        addEmptyOK("getAllianceName");
        addEmptyOK("getCharacterName"); // Concord officers don't have a character name ;-)
        addEmptyOK("getFactionName");
        final CorpKillMailParser parser = new CorpKillMailParser();
        prepareParser(parser);

        final KillMailResponse response = parser.getResponse(getCorp());
        testResponse(response);
    }

    @Test
    public void getResponseWalking() throws Exception {
        assumeTrue("Test not completed", TestControl.runTestIncomplete());
        testFail("Does not test KillMail walking");
    }

}
