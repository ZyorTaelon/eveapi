package com.beimin.eveapi.corporation.blueprints;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.corporation.CorpBlueprintsParser;
import com.beimin.eveapi.response.shared.BlueprintsResponse;

public class CorpBlueprintsParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void blueprintsParser() throws Exception {
        final CorpBlueprintsParser parser = new CorpBlueprintsParser();
        final BlueprintsResponse response = parser.getResponse(getCorp());
        testResponse(response);
    }

}