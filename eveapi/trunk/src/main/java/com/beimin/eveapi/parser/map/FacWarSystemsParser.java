package com.beimin.eveapi.parser.map;


import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.map.FacWarSystemsHandler;
import com.beimin.eveapi.model.map.FacWarSystem;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractListParser;
import com.beimin.eveapi.response.map.FacWarSystemsResponse;

public class FacWarSystemsParser extends AbstractListParser<FacWarSystemsHandler, FacWarSystemsResponse, FacWarSystem> {
	public FacWarSystemsParser() {
		super(FacWarSystemsResponse.class, 2, ApiPath.MAP, ApiPage.FACTION_WAR_SYSTEMS, FacWarSystemsHandler.class);
	}

	@Override
	public FacWarSystemsResponse getResponse() throws ApiException {
		return super.getResponse();
	}
}