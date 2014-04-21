package com.beimin.eveapi.character.skill.queue;

import static com.beimin.eveapi.utils.Assert.assertDate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Set;

import org.junit.Test;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.model.pilot.SkillQueueItem;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.pilot.SkillQueueParser;
import com.beimin.eveapi.response.pilot.SkillQueueResponse;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class SkillQueueParserTest extends FullAuthParserTest {
	public SkillQueueParserTest() {
		super(ApiPath.CHARACTER, ApiPage.SKILL_QUEUE);
	}

	@Test
	public void getResponse() throws ApiException {
		SkillQueueParser parser = new SkillQueueParser();
		SkillQueueResponse response = parser.getResponse(auth);
		assertNotNull(response);
		Set<SkillQueueItem> skillQueueItems = response.getAll();
		assertEquals(2, skillQueueItems.size());
		SkillQueueItem skillQueueItem = skillQueueItems.iterator().next();
		assertEquals(0, skillQueueItem.getQueuePosition());
		assertEquals(25739, skillQueueItem.getTypeID());
		assertEquals(5, skillQueueItem.getLevel());
		assertEquals(362039, skillQueueItem.getStartSP());
		assertEquals(2048000, skillQueueItem.getEndSP());
		assertDate(2010, 03, 28, 11, 00, 01, skillQueueItem.getStartTime());
		assertDate(2010, 04, 30, 4, 59, 46, skillQueueItem.getEndTime());
	}
}