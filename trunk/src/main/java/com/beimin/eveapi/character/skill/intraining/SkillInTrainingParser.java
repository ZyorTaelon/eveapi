package com.beimin.eveapi.character.skill.intraining;


import com.beimin.eveapi.core.AbstractApiParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.AbstractContentHandler;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

public class SkillInTrainingParser extends AbstractApiParser<SkillInTrainingResponse> {
	public SkillInTrainingParser() {
		super(SkillInTrainingResponse.class, 2, ApiPath.CHARACTER, ApiPage.SKILL_IN_TRAINING);
	}

	@Override
	protected AbstractContentHandler getContentHandler() {
		return new SkillInTrainingHandler();
	}

	public static SkillInTrainingParser getInstance() {
		return new SkillInTrainingParser();
	}

	@Override
	public SkillInTrainingResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}