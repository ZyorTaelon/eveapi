package com.beimin.eveapi.map.factwar.systems;

import org.junit.Ignore;
import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.map.FacWarSystemsParser;
import com.beimin.eveapi.response.map.FacWarSystemsResponse;

public class FacWarSystemsParserOnlineTest extends AbstractOnlineTest {

    @Test @Ignore("Some empty data")
    public void getResponse() throws Exception {
        final FacWarSystemsParser parser = new FacWarSystemsParser();
        prepareParser(parser);

        final FacWarSystemsResponse response = parser.getResponse();

        testResponse(response);
    }

}
