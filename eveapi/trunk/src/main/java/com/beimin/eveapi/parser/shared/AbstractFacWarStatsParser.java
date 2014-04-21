package com.beimin.eveapi.parser.shared;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.AbstractContentHandler;
import com.beimin.eveapi.handler.shared.FacWarStatsHandler;
import com.beimin.eveapi.parser.ApiAuth;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.response.shared.FacWarStatsResponse;

public class AbstractFacWarStatsParser extends AbstractApiParser<FacWarStatsResponse> {
	protected AbstractFacWarStatsParser(ApiPath path) {
		super(FacWarStatsResponse.class, 2, path, ApiPage.FACT_WAR_STATS);
	}

	@Override
	protected AbstractContentHandler getContentHandler() {
		return new FacWarStatsHandler();
	}

	@Override
	public FacWarStatsResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}