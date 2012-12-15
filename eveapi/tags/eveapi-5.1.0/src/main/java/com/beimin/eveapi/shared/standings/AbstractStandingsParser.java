package com.beimin.eveapi.shared.standings;


import com.beimin.eveapi.core.AbstractApiParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.AbstractContentHandler;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.exception.ApiException;

public abstract class AbstractStandingsParser extends AbstractApiParser<StandingsResponse> {

	protected AbstractStandingsParser(ApiPath path) {
		super(StandingsResponse.class, 2, path, ApiPage.STANDINGS);
	}

	@Override
	protected AbstractContentHandler getContentHandler() {
		return new StandingsHandler();
	}
	
	@Override
	public StandingsResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}