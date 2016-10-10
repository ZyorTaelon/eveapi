package com.beimin.eveapi.character.medals;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.pilot.MedalsParser;
import com.beimin.eveapi.response.pilot.MedalsResponse;
import org.junit.Ignore;

public class MedalsParserOnlineTest extends AbstractOnlineTest {

    @Test @Ignore("No data returned by the API")
    public void getResponse() throws Exception {
        final MedalsParser parser = new MedalsParser();
        final MedalsResponse response = parser.getResponse(getPilot());
        testResponse(response);
    }

}
