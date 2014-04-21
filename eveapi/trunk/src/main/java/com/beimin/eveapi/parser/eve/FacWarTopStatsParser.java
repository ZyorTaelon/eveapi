package com.beimin.eveapi.parser.eve;


import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.AbstractContentHandler;
import com.beimin.eveapi.handler.eve.FacWarTopStatsHandler;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractApiParser;
import com.beimin.eveapi.response.eve.FacWarTopStatsResponse;

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