package com.beimin.eveapi.character.training;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;
import org.xml.sax.SAXException;

public class ParserTest {

	@Test
	public void testSkillInTrainingParser() throws IOException, SAXException, ParseException {
		Parser parser = Parser.getInstance();
		InputStream input = ParserTest.class.getResourceAsStream("/SkillInTraining.xml");
		Response response = parser.getResponse(input);
		assertNotNull(response);
		Calendar calendar = Calendar.getInstance();
		calendar.set(2007, 5, 21, 21, 27, 50);
		Date endDate = calendar.getTime();
		assertEquals(endDate.toString(), response.getTrainingEndDate().toString());
		calendar.set(2007, 5, 21, 11, 00, 38);
		Date startDate = calendar.getTime();
		assertEquals(startDate.toString(), response.getTrainingStartDate().toString());
		assertEquals(3347, response.getTrainingTypeID());
		assertEquals(4000, response.getTrainingStartSP());
		assertEquals(22628, response.getTrainingDestinationSP());
		assertEquals(2, response.getTrainingToLevel());
		assertEquals(true, response.isSkillInTraining());
	}
}