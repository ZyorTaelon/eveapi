package com.beimin.eveapi.character.medals;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.pilot.MedalsParser;
import com.beimin.eveapi.response.pilot.MedalsResponse;

public class MedalsParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        final MedalsParser parser = new MedalsParser();
        final MedalsResponse response = parser.getResponse(getPilot());
        testResponse(response);
    }

}
