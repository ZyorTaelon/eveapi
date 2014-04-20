package com.beimin.eveapi.character.skill.queue;

import com.beimin.eveapi.core.AbstractListParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.exception.ApiException;

public class SkillQueueParser extends AbstractListParser<SkillQueueHandler, SkillQueueResponse, ApiSkillQueueItem> {
	public SkillQueueParser() {
		super(SkillQueueResponse.class, 2, ApiPath.CHARACTER, ApiPage.SKILL_QUEUE, SkillQueueHandler.class);
	}

	@Override
	public SkillQueueResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}