package com.beimin.eveapi.parser.character;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.AbstractContentHandler;
import com.beimin.eveapi.handler.character.SkillInTrainingHandler;
import com.beimin.eveapi.parser.ApiAuth;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractApiParser;
import com.beimin.eveapi.response.character.SkillInTrainingResponse;

public class SkillInTrainingParser extends AbstractApiParser<SkillInTrainingResponse> {
    public SkillInTrainingParser() {
        super(SkillInTrainingResponse.class, 2, ApiPath.CHARACTER, ApiPage.SKILL_IN_TRAINING);
    }

    @Override
    protected AbstractContentHandler<SkillInTrainingResponse> getContentHandler() {
        return new SkillInTrainingHandler();
    }

    @Override
    public SkillInTrainingResponse getResponse(final ApiAuth auth) throws ApiException {
        return super.getResponse(auth);
    }
}
