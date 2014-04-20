package com.beimin.eveapi.eve.factwar.stats;


import com.beimin.eveapi.core.AbstractApiParser;
import com.beimin.eveapi.core.AbstractContentHandler;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.exception.ApiException;

public class FacWarStatsParser extends AbstractApiParser<FacWarStatsResponse> {
	public FacWarStatsParser() {
		super(FacWarStatsResponse.class, 2, ApiPath.EVE, ApiPage.FACT_WAR_STATS);
	}

	@Override
	protected AbstractContentHandler getContentHandler() {
		return new FacWarStatsHandler();
	}

	@Override
	public FacWarStatsResponse getResponse() throws ApiException {
		return super.getResponse();
	}
}