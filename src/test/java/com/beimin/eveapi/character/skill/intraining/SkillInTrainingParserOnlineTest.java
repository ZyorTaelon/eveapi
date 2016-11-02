package com.beimin.eveapi.character.skill.intraining;

import static org.junit.Assume.assumeTrue;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.TestControl;
import com.beimin.eveapi.parser.pilot.SkillInTrainingParser;
import com.beimin.eveapi.response.pilot.SkillInTrainingResponse;

public class SkillInTrainingParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        assumeTrue("API Error", TestControl.runApiError());
        final SkillInTrainingParser parser = new SkillInTrainingParser();
        prepareParser(parser);

        final SkillInTrainingResponse response = parser.getResponse(getCharacter());

        testResponse(response);
    }

}
