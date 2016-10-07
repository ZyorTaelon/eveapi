package com.beimin.eveapi.eve.skilltree;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.eve.SkillTreeParser;
import com.beimin.eveapi.response.eve.SkillTreeResponse;

public class SkillTreeParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        final SkillTreeParser parser = new SkillTreeParser();
        final SkillTreeResponse response = parser.getResponse();
        testResponse(response);
    }

}