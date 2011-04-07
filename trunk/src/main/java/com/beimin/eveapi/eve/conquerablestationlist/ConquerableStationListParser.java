package com.beimin.eveapi.eve.conquerablestationlist;


import org.apache.commons.digester.Digester;

import com.beimin.eveapi.core.AbstractApiParser;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

public class ConquerableStationListParser extends AbstractApiParser<StationListResponse> {
	public ConquerableStationListParser() {
		super(StationListResponse.class, 2, ApiPath.EVE, ApiPage.CONQUERABLE_STATION_LIST);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", ApiStation.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "add");
		return digester;
	}

	public static ConquerableStationListParser getInstance() {
		return new ConquerableStationListParser();
	}

	@Override
	public StationListResponse getResponse() throws ApiException {
		return super.getResponse();
	}
}