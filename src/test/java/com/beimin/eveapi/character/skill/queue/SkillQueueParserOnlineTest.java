package com.beimin.eveapi.character.skill.queue;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.pilot.SkillQueueParser;
import com.beimin.eveapi.response.pilot.SkillQueueResponse;
import org.junit.Ignore;

public class SkillQueueParserOnlineTest extends AbstractOnlineTest {

    @Test @Ignore("No data returned by the API")
    public void getResponse() throws Exception {
        final SkillQueueParser parser = new SkillQueueParser();
        final SkillQueueResponse response = parser.getResponse(getPilot());
        testResponse(response);
    }

}
