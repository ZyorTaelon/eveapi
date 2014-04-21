package com.beimin.eveapi.parser.pilot;


import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.AbstractContentHandler;
import com.beimin.eveapi.handler.pilot.SkillInTrainingHandler;
import com.beimin.eveapi.parser.ApiAuth;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractApiParser;
import com.beimin.eveapi.response.pilot.SkillInTrainingResponse;

public class SkillInTrainingParser extends AbstractApiParser<SkillInTrainingResponse> {
	public SkillInTrainingParser() {
		super(SkillInTrainingResponse.class, 2, ApiPath.CHARACTER, ApiPage.SKILL_IN_TRAINING);
	}

	@Override
	protected AbstractContentHandler getContentHandler() {
		return new SkillInTrainingHandler();
	}

	@Override
	public SkillInTrainingResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}