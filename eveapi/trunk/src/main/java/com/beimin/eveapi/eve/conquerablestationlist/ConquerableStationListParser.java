package com.beimin.eveapi.eve.conquerablestationlist;


import com.beimin.eveapi.core.AbstractApiParser;
import com.beimin.eveapi.core.AbstractContentHandler;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.exception.ApiException;

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