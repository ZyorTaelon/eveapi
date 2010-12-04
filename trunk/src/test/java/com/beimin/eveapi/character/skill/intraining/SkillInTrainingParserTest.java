package com.beimin.eveapi.character.skill.intraining;

import static com.beimin.eveapi.utils.Assert.assertDate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.beimin.eveapi.FullApiParserTest;

public class SkillInTrainingParserTest extends FullApiParserTest {
	public SkillInTrainingParserTest() {
		super("/char/SkillInTraining.xml.aspx", "/character/SkillInTraining.xml");
	}

	@Test
	public void skillInTrainingParser() throws IOException, SAXException {
		SkillInTrainingParser parser = SkillInTrainingParser.getInstance();
		SkillInTrainingResponse response = parser.getSkillInTraining(auth);
		assertNotNull(response);
		assertDate(2008, 8, 17, 6, 43, 0, response.getCurrentTQTime());
		assertDate(2008, 8, 17, 15, 29, 44, response.getTrainingEndTime());
		assertDate(2008, 8, 15, 4, 1, 16, response.getTrainingStartTime());
		assertEquals(3305, response.getTrainingTypeID());
		assertEquals(24000, response.getTrainingStartSP());
		assertEquals(135765, response.getTrainingDestinationSP());
		assertEquals(4, response.getTrainingToLevel());
		assertEquals(true, response.isSkillInTraining());
	}
}