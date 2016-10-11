package com.beimin.eveapi.character.research;

import org.junit.Ignore;
import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.pilot.ResearchParser;
import com.beimin.eveapi.response.pilot.ResearchResponse;

public class ResearchParserOnlineTest extends AbstractOnlineTest {

    @Test @Ignore("No content")
    public void getResponse() throws Exception {
        final ResearchParser parser = new ResearchParser();
        prepareParser(parser);

        final ResearchResponse response = parser.getResponse(getCharacter());

        testResponse(response);
    }

}
