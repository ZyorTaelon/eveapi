package com.beimin.eveapi.parser.eve;


import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.AbstractContentHandler;
import com.beimin.eveapi.handler.eve.FacWarStatsHandler;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractApiParser;
import com.beimin.eveapi.response.eve.FacWarStatsResponse;

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