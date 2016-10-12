package com.beimin.eveapi.character.skill.queue;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.TestControl;
import com.beimin.eveapi.parser.pilot.SkillQueueParser;
import com.beimin.eveapi.response.pilot.SkillQueueResponse;
import static org.junit.Assume.assumeTrue;

public class SkillQueueParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        assumeTrue("No data returned by the API", TestControl.runNoData());
        final SkillQueueParser parser = new SkillQueueParser();
        prepareParser(parser);

        final SkillQueueResponse response = parser.getResponse(getCharacter());

        testResponse(response);
    }

}
