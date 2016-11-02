package com.beimin.eveapi.character.industryjobs;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.pilot.CharIndustryJobsParser;
import com.beimin.eveapi.response.shared.IndustryJobsResponse;

public class CharIndustryJobsParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        setAlias(IndustryJobsResponse.class, "jobs", "items");
        allowEmpty("getCompletedCharacterID"); // Not completed
        allowEmpty("getTeamID"); // Not in team
        allowEmpty("getSuccessfulRuns");
        final CharIndustryJobsParser parser = new CharIndustryJobsParser();
        prepareParser(parser);

        final IndustryJobsResponse response = parser.getResponse(getCharacter());

        testResponse(response);
    }

}
