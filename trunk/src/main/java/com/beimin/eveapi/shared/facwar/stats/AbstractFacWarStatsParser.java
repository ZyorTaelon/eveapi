package com.beimin.eveapi.shared.facwar.stats;

import com.beimin.eveapi.core.AbstractApiParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.AbstractContentHandler;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

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