package com.beimin.eveapi.eve.skilltree;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.Collection;
import java.util.Iterator;

import org.junit.Test;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.model.eve.CharacterAttribute;
import com.beimin.eveapi.model.eve.Skill;
import com.beimin.eveapi.model.eve.SkillGroup;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.eve.SkillTreeParser;
import com.beimin.eveapi.response.eve.SkillTreeResponse;
import com.beimin.eveapi.utils.NoAuthParserTest;

public class SkillTreeParserTest extends NoAuthParserTest {
    public SkillTreeParserTest() {
        super(ApiPath.EVE, ApiPage.SKILL_TREE);
    }

    @Test
    public void getResponse() throws ApiException {
        final SkillTreeParser parser = new SkillTreeParser();
        final SkillTreeResponse response = parser.getResponse();
        assertThat("Should have returned a response.", response, notNullValue());
        assertThat("version 2 expected.", response.getVersion(), equalTo(2));
        assertThat("Response should contain the current time.", response.getCurrentTime(), notNullValue());
        assertThat("Response should contain the time untill this response data is cached.", response.getCachedUntil(), notNullValue());
        assertThat("Should return some skill groups.", response.getAll().size() > 0, equalTo(true));
        final Collection<SkillGroup> skillGroups = response.getAll();
        assertThat(skillGroups.size(), equalTo(17));
        final SkillGroup skillGroup = skillGroups.iterator().next();
        assertThat(skillGroup.getGroupName(), equalTo("Corporation Management"));
        assertThat(skillGroup.getGroupID(), equalTo(266));
        final Collection<Skill> skills = skillGroup.getSkills();
        assertThat(skills.size(), equalTo(15));
        final Iterator<Skill> iterator = skills.iterator();
        Skill skill = iterator.next();
        assertThat(skill.getTypeID(), equalTo(11584));
        assertThat(skill.getTypeName(), equalTo("Anchoring"));
        assertThat(skill.isPublished(), equalTo(true));
        skill = iterator.next();
        assertThat(skill.getTypeID(), equalTo(3369));
        assertThat(skill.getTypeName(), equalTo("CFO Training"));
        assertThat(skill.isPublished(), equalTo(false));
        assertThat(skill.getPrimaryAttribute(), equalTo(CharacterAttribute.MEMORY));
        assertThat(skill.getSecondaryAttribute(), equalTo(CharacterAttribute.CHARISMA));

    }
}
