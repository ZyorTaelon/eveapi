package com.beimin.eveapi.character.research;

import com.beimin.eveapi.core.AbstractListParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.exception.ApiException;

public class ResearchParser extends AbstractListParser<ResearchHandler, ResearchResponse, ApiResearchAgent> {
	private ResearchParser() {
		super(ResearchResponse.class, 1, ApiPath.CHARACTER, ApiPage.RESEARCH, ResearchHandler.class);
	}

	public static ResearchParser getInstance() {
		return new ResearchParser();
	}

	@Override
	public ResearchResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}