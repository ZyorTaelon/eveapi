package com.beimin.eveapi.character.skill.queue;

import static com.beimin.eveapi.utils.Assert.assertDate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.beimin.eveapi.ApiPage;
import com.beimin.eveapi.ApiPath;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class SkillQueueParserTest extends FullAuthParserTest {
	public SkillQueueParserTest() {
		super(ApiPath.CHARACTER, ApiPage.SKILL_QUEUE);
	}

	@Test
	public void getResponse() throws IOException, SAXException {
		SkillQueueParser parser = SkillQueueParser.getInstance();
		SkillQueueResponse response = parser.getResponse(auth);
		assertNotNull(response);
		List<ApiSkillQueueItem> skillQueueItems = response.getSkillQueueItems();
		assertEquals(2, skillQueueItems.size());
		ApiSkillQueueItem skillQueueItem = skillQueueItems.iterator().next();
		assertEquals(0, skillQueueItem.getQueuePosition());
		assertEquals(25739, skillQueueItem.getTypeID());
		assertEquals(5, skillQueueItem.getLevel());
		assertEquals(362039, skillQueueItem.getStartSP());
		assertEquals(2048000, skillQueueItem.getEndSP());
		assertDate(2010, 03, 28, 11, 00, 01, skillQueueItem.getStartTime());
		assertDate(2010, 04, 30, 4, 59, 46, skillQueueItem.getEndTime());
	}
}