package com.beimin.eveapi.parser.pilot;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.pilot.ResearchHandler;
import com.beimin.eveapi.model.pilot.ResearchAgent;
import com.beimin.eveapi.parser.ApiAuth;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractListParser;
import com.beimin.eveapi.response.pilot.ResearchResponse;

public class ResearchParser extends AbstractListParser<ResearchHandler, ResearchResponse, ResearchAgent> {
	public ResearchParser() {
		super(ResearchResponse.class, 1, ApiPath.CHARACTER, ApiPage.RESEARCH, ResearchHandler.class);
	}

	@Override
	public ResearchResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}