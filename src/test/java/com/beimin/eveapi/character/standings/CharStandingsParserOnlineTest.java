package com.beimin.eveapi.character.standings;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.TestControl;
import com.beimin.eveapi.parser.pilot.CharStandingsParser;
import com.beimin.eveapi.response.shared.StandingsResponse;
import static org.junit.Assume.assumeTrue;

public class CharStandingsParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        assumeTrue("Some data missing", TestControl.runIncompleteDataset());
        final CharStandingsParser parser = new CharStandingsParser();
        prepareParser(parser);

        final StandingsResponse response = parser.getResponse(getCharacter());

        testResponse(response);
    }

}
