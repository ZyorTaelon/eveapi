package com.beimin.eveapi.map.sovereignty;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.map.SovereigntyParser;
import com.beimin.eveapi.response.map.SovereigntyResponse;

public class SovereigntyParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        addEmptyOK("getAllianceID"); // No alliance
        addEmptyOK("getCorporationID"); // No corporation
        final SovereigntyParser parser = new SovereigntyParser();
        final SovereigntyResponse response = parser.getResponse();
        testResponse(response, 1);
    }

}
