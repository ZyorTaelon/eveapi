package com.beimin.eveapi.character.skill.intraining;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;
import org.xml.sax.SAXException;

public class SkillInTrainingParserTest {

	@Test
	public void skillInTrainingParser() throws IOException, SAXException, ParseException {
		SkillInTrainingParser parser = SkillInTrainingParser.getInstance();
		InputStream input = SkillInTrainingParserTest.class.getResourceAsStream("/character/SkillInTraining.xml");
		SkillInTrainingResponse response = parser.getResponse(input);
		assertNotNull(response);
		Calendar calendar = Calendar.getInstance();
		calendar.set(2008, 7, 17, 6, 43, 00); // 2008-08-17 06:43:00
		Date currentTQDate = calendar.getTime();
		assertEquals(currentTQDate.toString(), response.getCurrentTQDate().toString());
		calendar.set(2008, 7, 17, 15, 29, 44); // 2008-08-17 15:29:44
		Date endDate = calendar.getTime();
		assertEquals(endDate.toString(), response.getTrainingEndDate().toString());
		calendar.set(2008, 7, 15, 4, 1, 16); // 2008-08-15 04:01:16
		Date startDate = calendar.getTime();
		assertEquals(startDate.toString(), response.getTrainingStartDate().toString());
		assertEquals(3305, response.getTrainingTypeID());
		assertEquals(24000, response.getTrainingStartSP());
		assertEquals(135765, response.getTrainingDestinationSP());
		assertEquals(4, response.getTrainingToLevel());
		assertEquals(true, response.isSkillInTraining());
	}
}