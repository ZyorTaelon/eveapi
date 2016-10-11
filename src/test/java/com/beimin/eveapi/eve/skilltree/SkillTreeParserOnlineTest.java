package com.beimin.eveapi.eve.skilltree;

import org.junit.Ignore;
import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.eve.SkillTreeParser;
import com.beimin.eveapi.response.eve.SkillTreeResponse;

public class SkillTreeParserOnlineTest extends AbstractOnlineTest {

    @Test @Ignore("New fields test not working")
    public void getResponse() throws Exception {
        final SkillTreeParser parser = new SkillTreeParser();
        prepareParser(parser);

        final SkillTreeResponse response = parser.getResponse();

        testResponse(response);
    }

}
