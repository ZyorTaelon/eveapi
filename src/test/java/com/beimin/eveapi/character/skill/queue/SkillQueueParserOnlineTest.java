package com.beimin.eveapi.character.skill.queue;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.character.SkillQueueParser;
import com.beimin.eveapi.response.character.SkillQueueResponse;

public class SkillQueueParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        setAlias(SkillQueueResponse.class, "skillqueue", "items");
        allowEmpty("getQueuePosition");
        final SkillQueueParser parser = new SkillQueueParser();
        prepareParser(parser);

        final SkillQueueResponse response = parser.getResponse(getCharacter());

        testResponse(response);
    }

}
