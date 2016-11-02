package com.beimin.eveapi.parser.character;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.character.SkillQueueHandler;
import com.beimin.eveapi.model.character.SkillQueueItem;
import com.beimin.eveapi.parser.ApiAuth;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractListParser;
import com.beimin.eveapi.response.character.SkillQueueResponse;

public class SkillQueueParser extends AbstractListParser<SkillQueueHandler, SkillQueueResponse, SkillQueueItem> {
    public SkillQueueParser() {
        super(SkillQueueResponse.class, 2, ApiPath.CHARACTER, ApiPage.SKILL_QUEUE, SkillQueueHandler.class);
    }

    @Override
    public SkillQueueResponse getResponse(final ApiAuth auth) throws ApiException {
        return super.getResponse(auth);
    }
}
