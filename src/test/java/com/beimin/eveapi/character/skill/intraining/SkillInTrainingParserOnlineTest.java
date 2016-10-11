package com.beimin.eveapi.character.skill.intraining;

import org.junit.Ignore;
import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.pilot.SkillInTrainingParser;
import com.beimin.eveapi.response.pilot.SkillInTrainingResponse;

public class SkillInTrainingParserOnlineTest extends AbstractOnlineTest {

    @Test @Ignore("Some data missing")
    public void getResponse() throws Exception {
        addNullOk("getTrainingEndTime"); // No skill in traning
        addNullOk("getTrainingStartTime"); // No skill in traning
        final SkillInTrainingParser parser = new SkillInTrainingParser();
        prepareParser(parser);

        final SkillInTrainingResponse response = parser.getResponse(getCharacter());

        testResponse(response);
    }

}
