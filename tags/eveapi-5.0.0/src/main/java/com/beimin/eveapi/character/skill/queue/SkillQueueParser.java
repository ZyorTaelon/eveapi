package com.beimin.eveapi.character.skill.queue;

import com.beimin.eveapi.core.AbstractListParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

public class SkillQueueParser extends AbstractListParser<SkillQueueHandler, SkillQueueResponse, ApiSkillQueueItem> {
	public SkillQueueParser() {
		super(SkillQueueResponse.class, 2, ApiPath.CHARACTER, ApiPage.SKILL_QUEUE, SkillQueueHandler.class);
	}

	public static SkillQueueParser getInstance() {
		return new SkillQueueParser();
	}

	@Override
	public SkillQueueResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}