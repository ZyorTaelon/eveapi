package com.beimin.eveapi.character.skill.queue;


import com.beimin.eveapi.AbstractOnlineTest;

import org.junit.Test;

import com.beimin.eveapi.parser.pilot.SkillQueueParser;
import com.beimin.eveapi.response.pilot.SkillQueueResponse;

public class SkillQueueParserOnlineTest extends AbstractOnlineTest {

	@Test
	public void getResponse() throws Exception {
		SkillQueueParser parser = new SkillQueueParser();
		SkillQueueResponse response = parser.getResponse(getPilot());
		testResponse(response);
	}

}