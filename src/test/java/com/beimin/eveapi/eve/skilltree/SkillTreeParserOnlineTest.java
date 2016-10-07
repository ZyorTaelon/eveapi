package com.beimin.eveapi.eve.skilltree;


import com.beimin.eveapi.AbstractOnlineTest;

import org.junit.Test;

import com.beimin.eveapi.parser.eve.SkillTreeParser;
import com.beimin.eveapi.response.eve.SkillTreeResponse;

public class SkillTreeParserOnlineTest extends AbstractOnlineTest {

	@Test
	public void getResponse() throws Exception {
		SkillTreeParser parser = new SkillTreeParser();
		SkillTreeResponse response = parser.getResponse();
		testResponse(response);
	}

}