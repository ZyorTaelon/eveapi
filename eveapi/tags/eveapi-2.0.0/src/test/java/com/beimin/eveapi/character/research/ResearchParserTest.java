package com.beimin.eveapi.character.research;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.junit.Test;
import org.xml.sax.SAXException;

public class ResearchParserTest {

	@Test
	public void notificationsParser() throws IOException, SAXException {
		ResearchParser parser = ResearchParser.getInstance();
		InputStream input = ResearchParserTest.class.getResourceAsStream("/character/Research.xml");
		ResearchResponse response = parser.getResponse(input);
		assertNotNull(response);
		List<ApiResearchAgent> researchAgents = response.getResearchAgents();
		assertNotNull(researchAgents);
		assertEquals(5, researchAgents.size());
		boolean found = false;
		for (ApiResearchAgent researchAgent : researchAgents) {
			if(researchAgent.getAgentID()==3012659){
				found=true;
				assertEquals(11452, researchAgent.getSkillTypeID());
				assertEquals("2009-10-14 21:37:42", researchAgent.getResearchStartDate());
				assertEquals(111.78, researchAgent.getPointsPerDay());
				assertEquals(40.9576281249902, researchAgent.getRemainderPoints());
				break;
			}
		}
		assertTrue("Test agent wasn't found.", found);
	}
}