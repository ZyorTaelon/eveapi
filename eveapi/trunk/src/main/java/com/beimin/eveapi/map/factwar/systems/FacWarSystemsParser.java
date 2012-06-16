package com.beimin.eveapi.map.factwar.systems;


import com.beimin.eveapi.core.AbstractListParser;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.exception.ApiException;

public class FacWarSystemsParser extends AbstractListParser<FacWarSystemsHandler, FacWarSystemsResponse, ApiFacWarSystem> {
	private FacWarSystemsParser() {
		super(FacWarSystemsResponse.class, 2, ApiPath.MAP, ApiPage.FACTION_WAR_SYSTEMS, FacWarSystemsHandler.class);
	}
	
	public static FacWarSystemsParser getInstance() {
		return new FacWarSystemsParser();
	}

	@Override
	public FacWarSystemsResponse getResponse() throws ApiException {
		return super.getResponse();
	}
}