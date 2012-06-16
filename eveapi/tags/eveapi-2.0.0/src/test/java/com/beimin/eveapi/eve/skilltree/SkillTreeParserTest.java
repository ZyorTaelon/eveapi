package com.beimin.eveapi.eve.skilltree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.beimin.eveapi.corporation.starbase.list.StarbaseListParserTest;

public class SkillTreeParserTest {
	@Test
	public void skillTreeParser() throws IOException, SAXException {
		InputStream input = StarbaseListParserTest.class.getResourceAsStream("/eve/SkillTree.xml");
		SkillTreeParser parser = SkillTreeParser.getInstance();
		SkillTreeResponse response = parser.getResponse(input);
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