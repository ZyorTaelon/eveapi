package com.beimin.eveapi.eve.factwar.stats.top;


import com.beimin.eveapi.core.AbstractApiParser;
import com.beimin.eveapi.core.AbstractContentHandler;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.exception.ApiException;

public class FacWarTopStatsParser extends AbstractApiParser<FacWarTopStatsResponse> {
	public FacWarTopStatsParser() {
		super(FacWarTopStatsResponse.class, 2, ApiPath.EVE, ApiPage.FACT_WAR_TOP_STATS);
	}

	@Override
	protected AbstractContentHandler getContentHandler() {
		return new FacWarTopStatsHandler();
	}

	@Override
	public FacWarTopStatsResponse getResponse() throws ApiException {
		return super.getResponse();
	}
}