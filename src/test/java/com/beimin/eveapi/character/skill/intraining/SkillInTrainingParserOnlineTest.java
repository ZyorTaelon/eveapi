package com.beimin.eveapi.character.skill.intraining;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.TestControl;
import com.beimin.eveapi.parser.pilot.SkillInTrainingParser;
import com.beimin.eveapi.response.pilot.SkillInTrainingResponse;
import static org.junit.Assume.assumeTrue;

public class SkillInTrainingParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        assumeTrue("Other error", TestControl.runOther());
        addNullOk("getTrainingEndTime"); // No skill in traning
        addNullOk("getTrainingStartTime"); // No skill in traning
        final SkillInTrainingParser parser = new SkillInTrainingParser();
        prepareParser(parser);

        final SkillInTrainingResponse response = parser.getResponse(getCharacter());

        testResponse(response);
    }

}
