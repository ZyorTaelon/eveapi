package com.beimin.eveapi.character.skill.queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.List;

import org.junit.Test;
import org.xml.sax.SAXException;

public class SkillQueueParserTest {

	@Test
	public void skillInTrainingParser() throws IOException, SAXException, ParseException {
		SkillQueueParser parser = SkillQueueParser.getInstance();
		InputStream input = SkillQueueParserTest.class.getResourceAsStream("/character/SkillQueue.xml");
		SkillQueueResponse response = parser.getResponse(input);
		assertNotNull(response);
		List<ApiSkillQueueItem> skillQueueItems = response.getSkillQueueItems();
		assertEquals(2, skillQueueItems.size());
		ApiSkillQueueItem skillQueueItem = skillQueueItems.iterator().next();
		assertEquals(0, skillQueueItem.getQueuePosition());
		assertEquals(25739, skillQueueItem.getTypeID());
		assertEquals(5, skillQueueItem.getLevel());
		assertEquals(362039, skillQueueItem.getStartSP());
		assertEquals(2048000, skillQueueItem.getEndSP());
		assertEquals("2010-03-28 11:00:01", skillQueueItem.getStartTime());
		assertEquals("2010-04-30 04:59:46", skillQueueItem.getEndTime());
	}
}