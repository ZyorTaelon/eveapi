package com.beimin.eveapi.corporation.medals;

import org.junit.Ignore;
import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.corporation.MedalsParser;
import com.beimin.eveapi.response.corporation.MedalsResponse;

public class MedalsParserOnlineTest extends AbstractOnlineTest {

    @Test @Ignore("No data returned by the API")
    public void getResponse() throws Exception {
        final MedalsParser parser = new MedalsParser();
        prepareParser(parser);

        final MedalsResponse response = parser.getResponse(getCorp());

        testResponse(response);
    }

}
