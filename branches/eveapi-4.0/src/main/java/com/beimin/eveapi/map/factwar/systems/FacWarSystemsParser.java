package com.beimin.eveapi.map.factwar.systems;


import com.beimin.eveapi.core.AbstractListParser;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

public class FacWarSystemsParser extends AbstractListParser<FacWarSystemsResponse, ApiFacWarSystem> {
	private FacWarSystemsParser() {
		super(FacWarSystemsResponse.class, 2, ApiPath.MAP, ApiPage.FACTION_WAR_SYSTEMS, ApiFacWarSystem.class);
	}

	public static FacWarSystemsParser getInstance() {
		return new FacWarSystemsParser();
	}

	@Override
	public FacWarSystemsResponse getResponse() throws ApiException {
		return super.getResponse();
	}
}