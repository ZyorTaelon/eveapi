package com.beimin.eveapi.character.research;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.pilot.ResearchParser;
import com.beimin.eveapi.response.pilot.ResearchResponse;

public class ResearchParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        setAlias(ResearchResponse.class, "research", "items");
        final ResearchParser parser = new ResearchParser();
        prepareParser(parser);

        final ResearchResponse response = parser.getResponse(getCharacter());

        testResponse(response);
    }

}
