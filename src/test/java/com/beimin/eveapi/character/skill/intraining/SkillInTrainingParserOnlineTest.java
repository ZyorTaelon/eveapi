package com.beimin.eveapi.character.skill.intraining;


import com.beimin.eveapi.AbstractOnlineTest;
import org.junit.Test;

import com.beimin.eveapi.parser.pilot.SkillInTrainingParser;
import com.beimin.eveapi.response.pilot.SkillInTrainingResponse;

public class SkillInTrainingParserOnlineTest extends AbstractOnlineTest {

	@Test
	public void getResponse() throws Exception {
		addNullOk("getTrainingEndTime"); //No skill in traning
		addNullOk("getTrainingStartTime"); //No skill in traning
		SkillInTrainingParser parser = new SkillInTrainingParser();
		SkillInTrainingResponse response = parser.getResponse(getPilot());
		testResponse(response);
	}

}