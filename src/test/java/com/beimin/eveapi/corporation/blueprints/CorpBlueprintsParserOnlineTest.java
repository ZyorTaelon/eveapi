package com.beimin.eveapi.corporation.blueprints;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.TestControl;
import com.beimin.eveapi.parser.corporation.CorpBlueprintsParser;
import com.beimin.eveapi.response.shared.BlueprintsResponse;
import static org.junit.Assume.assumeTrue;

public class CorpBlueprintsParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void blueprintsParser() throws Exception {
        assumeTrue("No data returned by the API", TestControl.runNoData());
        final CorpBlueprintsParser parser = new CorpBlueprintsParser();
        prepareParser(parser);

        final BlueprintsResponse response = parser.getResponse(getCorp());

        testResponse(response);
    }

}
