package com.beimin.eveapi.character.industryjobs;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.pilot.CharIndustryJobsParser;
import com.beimin.eveapi.response.shared.IndustryJobsResponse;

public class CharIndustryJobsParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        final CharIndustryJobsParser parser = new CharIndustryJobsParser();
        final IndustryJobsResponse response = parser.getResponse(getPilot());
        testResponse(response);
    }

}
