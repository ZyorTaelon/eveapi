package com.beimin.eveapi.eve.skilltree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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
		SkillTreeParser parser = new SkillTreeParser();
		SkillTreeResponse response = parser.getResponse();
		assertNotNull("Should have returned a response.", response);
		assertEquals("version 2 expected.", 2, response.getVersion());
		assertNotNull("Response should contain the current time.", response.getCurrentTime());
		assertNotNull("Response should contain the time untill this response data is cached.", response.getCachedUntil());
		assertTrue("Should return some skill groups.", response.getAll().size() > 0);
		Collection<SkillGroup> skillGroups = response.getAll();
		assertEquals(17, skillGroups.size());
		SkillGroup skillGroup = skillGroups.iterator().next();
		assertEquals("Corporation Management", skillGroup.getGroupName());
		assertEquals(266, skillGroup.getGroupID());
		Collection<Skill> skills = skillGroup.getSkills();
		assertEquals(15, skills.size());
		Iterator<Skill> iterator = skills.iterator();
		Skill skill = iterator.next();
		assertEquals(11584, skill.getTypeID());
		assertEquals("Anchoring", skill.getTypeName());
		assertTrue(skill.isPublished());
		skill = iterator.next();
		assertEquals(3369, skill.getTypeID());
		assertEquals("CFO Training", skill.getTypeName());
		assertFalse(skill.isPublished());
		assertEquals(CharacterAttribute.MEMORY, skill.getPrimaryAttribute());
		assertEquals(CharacterAttribute.CHARISMA, skill.getSecondaryAttribute());

	}
}