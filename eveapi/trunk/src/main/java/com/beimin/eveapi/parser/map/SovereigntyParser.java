package com.beimin.eveapi.parser.map;


import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.map.SovereigntyHandler;
import com.beimin.eveapi.model.map.SystemSovereignty;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractListParser;
import com.beimin.eveapi.response.map.SovereigntyResponse;

public class SovereigntyParser extends AbstractListParser<SovereigntyHandler, SovereigntyResponse, SystemSovereignty> {
	public SovereigntyParser() {
		super(SovereigntyResponse.class, 1, ApiPath.MAP, ApiPage.SOVEREIGNTY, SovereigntyHandler.class);
	}

	@Override
	public SovereigntyResponse getResponse() throws ApiException {
		return super.getResponse();
	}
}