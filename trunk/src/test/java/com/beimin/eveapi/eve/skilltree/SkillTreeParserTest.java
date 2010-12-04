package com.beimin.eveapi.eve.skilltree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Collection;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.beimin.eveapi.ApiPage;
import com.beimin.eveapi.ApiPath;
import com.beimin.eveapi.utils.NoAuthParserTest;

public class SkillTreeParserTest extends NoAuthParserTest {
	public SkillTreeParserTest() {
		super(ApiPath.EVE, ApiPage.SKILL_TREE);
	}

	@Test
	public void getResponse() throws IOException, SAXException {
		SkillTreeParser parser = SkillTreeParser.getInstance();
		SkillTreeResponse response = parser.getResponse();
		assertNotNull("Should have returned a response.", response);
		assertEquals("version 2 expected.", 2, response.getVersion());
		assertNotNull("Response should contain the current time.", response.getCurrentTime());
		assertNotNull("Response should contain the time untill this response data is cached.", response.getCachedUntil());
		assertTrue("Should return some skill groups.", response.getSkillGroups().size() > 0);
		Collection<ApiSkillGroup> skillGroups = response.getSkillGroups();
		for (ApiSkillGroup skillGroup : skillGroups) {
			assertNotNull("Group should have a name.", skillGroup.getGroupName());
			assertTrue("Group should have an Id.", skillGroup.getGroupID() > 0);
			assertTrue("Group " + skillGroup.getGroupName() + " should have some skills.", skillGroup.getSkills().size() > 0);
		}
	}
}