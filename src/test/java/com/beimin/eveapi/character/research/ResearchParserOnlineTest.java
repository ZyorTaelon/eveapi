package com.beimin.eveapi.character.research;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.TestControl;
import com.beimin.eveapi.parser.pilot.ResearchParser;
import com.beimin.eveapi.response.pilot.ResearchResponse;
import static org.junit.Assume.assumeTrue;

public class ResearchParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        assumeTrue("No data returned by the API", TestControl.runNoData());
        final ResearchParser parser = new ResearchParser();
        prepareParser(parser);

        final ResearchResponse response = parser.getResponse(getCharacter());

        testResponse(response);
    }

}
