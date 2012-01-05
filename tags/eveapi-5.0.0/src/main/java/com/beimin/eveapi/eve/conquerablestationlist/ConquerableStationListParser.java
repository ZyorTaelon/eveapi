package com.beimin.eveapi.eve.conquerablestationlist;


import com.beimin.eveapi.core.AbstractApiParser;
import com.beimin.eveapi.core.AbstractContentHandler;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

public class ConquerableStationListParser extends AbstractApiParser<StationListResponse> {
	public ConquerableStationListParser() {
		super(StationListResponse.class, 2, ApiPath.EVE, ApiPage.CONQUERABLE_STATION_LIST);
	}

	@Override
	protected AbstractContentHandler getContentHandler() {
		return new ConquerableStationListHandler();
	}

	public static ConquerableStationListParser getInstance() {
		return new ConquerableStationListParser();
	}

	@Override
	public StationListResponse getResponse() throws ApiException {
		return super.getResponse();
	}
}