package com.beimin.eveapi.character.skill.queue;

import static com.beimin.eveapi.utils.Assert.assertDate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Set;

import org.junit.Test;

import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class SkillQueueParserTest extends FullAuthParserTest {
	public SkillQueueParserTest() {
		super(ApiPath.CHARACTER, ApiPage.SKILL_QUEUE);
	}

	@Test
	public void getResponse() throws ApiException {
		SkillQueueParser parser = SkillQueueParser.getInstance();
		SkillQueueResponse response = parser.getResponse(auth);
		assertNotNull(response);
		Set<ApiSkillQueueItem> skillQueueItems = response.getAll();
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