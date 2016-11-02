package com.beimin.eveapi.parser.character;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.character.ResearchHandler;
import com.beimin.eveapi.model.character.ResearchAgent;
import com.beimin.eveapi.parser.ApiAuth;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractListParser;
import com.beimin.eveapi.response.character.ResearchResponse;

public class ResearchParser extends AbstractListParser<ResearchHandler, ResearchResponse, ResearchAgent> {
    public ResearchParser() {
        super(ResearchResponse.class, 2, ApiPath.CHARACTER, ApiPage.RESEARCH, ResearchHandler.class);
    }

    @Override
    public ResearchResponse getResponse(final ApiAuth auth) throws ApiException {
        return super.getResponse(auth);
    }
}
