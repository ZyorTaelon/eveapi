package com.beimin.eveapi.character.industryjobs;

import org.junit.Ignore;
import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.pilot.CharIndustryJobsParser;
import com.beimin.eveapi.response.shared.IndustryJobsResponse;

public class CharIndustryJobsParserOnlineTest extends AbstractOnlineTest {

    @Test @Ignore("No data returned by the API")
    public void getResponse() throws Exception {
        final CharIndustryJobsParser parser = new CharIndustryJobsParser();
        prepareParser(parser);

        final IndustryJobsResponse response = parser.getResponse(getCharacter());

        testResponse(response);
    }

}
