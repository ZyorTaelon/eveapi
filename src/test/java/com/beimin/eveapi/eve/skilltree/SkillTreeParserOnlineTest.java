package com.beimin.eveapi.eve.skilltree;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.model.eve.Skill;
import com.beimin.eveapi.parser.eve.SkillTreeParser;
import com.beimin.eveapi.response.eve.SkillTreeResponse;

public class SkillTreeParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        ignoreXmlField("requiredAttributes");
        setAlias(Skill.class, "skillBonusCollection", "boneses");
        setAlias(SkillTreeResponse.class, "skillGroups", "items");
        final SkillTreeParser parser = new SkillTreeParser();
        prepareParser(parser);

        final SkillTreeResponse response = parser.getResponse();

        testResponse(response);
    }

}
