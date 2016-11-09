package com.beimin.eveapi.character.research;

import static com.beimin.eveapi.utils.Assert.assertDate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.model.character.ResearchAgent;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.character.ResearchParser;
import com.beimin.eveapi.response.character.ResearchResponse;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class ResearchParserTest extends FullAuthParserTest {
    public ResearchParserTest() {
        super(ApiPath.CHARACTER, ApiPage.RESEARCH);
    }

    @Test
    public void getResponse() throws ApiException {
        final ResearchParser parser = new ResearchParser();
        final ResearchResponse response = parser.getResponse(auth);
        assertNotNull(response);
        final List<ResearchAgent> researchAgents = response.getAll();
        assertNotNull(researchAgents);
        assertEquals(5, researchAgents.size());
        boolean found = false;
        for (final ResearchAgent researchAgent : researchAgents) {
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
