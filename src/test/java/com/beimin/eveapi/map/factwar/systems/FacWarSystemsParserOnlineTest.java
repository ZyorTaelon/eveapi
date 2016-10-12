package com.beimin.eveapi.map.factwar.systems;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.TestControl;
import com.beimin.eveapi.parser.map.FacWarSystemsParser;
import com.beimin.eveapi.response.map.FacWarSystemsResponse;
import static org.junit.Assume.assumeTrue;

public class FacWarSystemsParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        assumeTrue("Other error", TestControl.runOther());
        final FacWarSystemsParser parser = new FacWarSystemsParser();
        prepareParser(parser);

        final FacWarSystemsResponse response = parser.getResponse();

        testResponse(response);
    }

}
