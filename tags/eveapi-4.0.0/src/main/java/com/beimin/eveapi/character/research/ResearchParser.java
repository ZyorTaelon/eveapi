package com.beimin.eveapi.character.research;


import com.beimin.eveapi.core.AbstractListParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

public class ResearchParser extends AbstractListParser<ResearchResponse, ApiResearchAgent> {
	private ResearchParser() {
		super(ResearchResponse.class, 1, ApiPath.CHARACTER, ApiPage.RESEARCH, ApiResearchAgent.class);
	}

	public static ResearchParser getInstance() {
		return new ResearchParser();
	}

	@Override
	public ResearchResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}