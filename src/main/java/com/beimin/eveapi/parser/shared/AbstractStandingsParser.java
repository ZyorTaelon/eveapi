package com.beimin.eveapi.parser.shared;


import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.AbstractContentHandler;
import com.beimin.eveapi.handler.shared.StandingsHandler;
import com.beimin.eveapi.parser.ApiAuth;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.response.shared.StandingsResponse;

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