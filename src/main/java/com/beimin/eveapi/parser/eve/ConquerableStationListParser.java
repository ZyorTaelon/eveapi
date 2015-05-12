package com.beimin.eveapi.parser.eve;


import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.AbstractContentHandler;
import com.beimin.eveapi.handler.eve.ConquerableStationListHandler;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractApiParser;
import com.beimin.eveapi.response.eve.StationListResponse;

public class ConquerableStationListParser extends AbstractApiParser<StationListResponse> {
	public ConquerableStationListParser() {
		super(StationListResponse.class, 2, ApiPath.EVE, ApiPage.CONQUERABLE_STATION_LIST);
	}

	@Override
	protected AbstractContentHandler getContentHandler() {
		return new ConquerableStationListHandler();
	}

	@Override
	public StationListResponse getResponse() throws ApiException {
		return super.getResponse();
	}
}