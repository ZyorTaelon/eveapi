package com.beimin.eveapi.character.research;

import static com.beimin.eveapi.utils.Assert.assertDate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.beimin.eveapi.FullApiParserTest;

public class ResearchParserTest extends FullApiParserTest {
	public ResearchParserTest() {
		super("/char/Research.xml.aspx", "/character/Research.xml");
	}

	@Test
	public void notificationsParser() throws IOException, SAXException {
		ResearchParser parser = ResearchParser.getInstance();
		ResearchResponse response = parser.getResearchResponse(auth);
		assertNotNull(response);
		List<ApiResearchAgent> researchAgents = response.getResearchAgents();
		assertNotNull(researchAgents);
		assertEquals(5, researchAgents.size());
		boolean found = false;
		for (ApiResearchAgent researchAgent : researchAgents) {
			if (researchAgent.getAgentID() == 3012659) {
				found = true;
				assertEquals(11452, researchAgent.getSkillTypeID());
				assertDate(2009, 10, 14, 21, 37, 42, researchAgent.getResearchStartDate());
				assertEquals(111.78, researchAgent.getPointsPerDay(), 0.0001);
				assertEquals(40.9576281249902, researchAgent.getRemainderPoints(), 1E-15);
				break;
			}
		}
		assertTrue("Test agent wasn't found.", found);
	}
}