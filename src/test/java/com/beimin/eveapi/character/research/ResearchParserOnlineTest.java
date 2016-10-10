package com.beimin.eveapi.character.research;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.pilot.ResearchParser;
import com.beimin.eveapi.response.pilot.ResearchResponse;
import org.junit.Ignore;

public class ResearchParserOnlineTest extends AbstractOnlineTest {

    @Test @Ignore("API Error")
    public void getResponse() throws Exception {
        final ResearchParser parser = new ResearchParser();
        final ResearchResponse response = parser.getResponse(getPilot());
        testResponse(response, 1);
    }

}
