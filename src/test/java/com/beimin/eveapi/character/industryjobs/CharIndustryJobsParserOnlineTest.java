package com.beimin.eveapi.character.industryjobs;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.TestControl;
import com.beimin.eveapi.parser.pilot.CharIndustryJobsParser;
import com.beimin.eveapi.response.shared.IndustryJobsResponse;
import static org.junit.Assume.assumeTrue;

public class CharIndustryJobsParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        assumeTrue("No data returned by the API", TestControl.runNoData());
        addEmptyOK("getCompletedCharacterID"); //Not completed
        addEmptyOK("getTeamID"); //Not in team
        final CharIndustryJobsParser parser = new CharIndustryJobsParser();
        prepareParser(parser);

        final IndustryJobsResponse response = parser.getResponse(getCharacter());

        testResponse(response);
    }

}
