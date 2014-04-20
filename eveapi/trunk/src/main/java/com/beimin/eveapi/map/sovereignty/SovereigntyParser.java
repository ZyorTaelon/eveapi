package com.beimin.eveapi.map.sovereignty;


import com.beimin.eveapi.core.AbstractListParser;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.exception.ApiException;

public class SovereigntyParser extends AbstractListParser<SovereigntyHandler, SovereigntyResponse, ApiSystemSovereignty> {
	public SovereigntyParser() {
		super(SovereigntyResponse.class, 1, ApiPath.MAP, ApiPage.SOVEREIGNTY, SovereigntyHandler.class);
	}

	@Override
	public SovereigntyResponse getResponse() throws ApiException {
		return super.getResponse();
	}
}