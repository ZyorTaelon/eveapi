package com.beimin.eveapi.character.medals;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.TestControl;
import com.beimin.eveapi.parser.pilot.MedalsParser;
import com.beimin.eveapi.response.pilot.MedalsResponse;
import static org.junit.Assume.assumeTrue;

public class MedalsParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        assumeTrue("No data returned by the API", TestControl.runNoData());
        final MedalsParser parser = new MedalsParser();
        prepareParser(parser);

        final MedalsResponse response = parser.getResponse(getCharacter());

        testResponse(response);
    }

}
