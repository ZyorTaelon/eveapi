package com.beimin.eveapi.corporation.medals;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.corporation.MedalsParser;
import com.beimin.eveapi.response.corporation.MedalsResponse;
import org.junit.Ignore;

public class MedalsParserOnlineTest extends AbstractOnlineTest {

    @Test @Ignore("No data returned by the API")
    public void getResponse() throws Exception {
        final MedalsParser parser = new MedalsParser();
        final MedalsResponse response = parser.getResponse(getCorp());
        testResponse(response);
    }

}
