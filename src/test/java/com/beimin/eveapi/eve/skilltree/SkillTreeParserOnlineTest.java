package com.beimin.eveapi.eve.skilltree;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.eve.SkillTreeParser;
import com.beimin.eveapi.response.eve.SkillTreeResponse;

public class SkillTreeParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        addIgnoreElement("row");
        addIgnoreElement("requiredAttributes");
        final SkillTreeParser parser = new SkillTreeParser();
        prepareParser(parser);

        final SkillTreeResponse response = parser.getResponse();

        testResponse(response);
    }

}
