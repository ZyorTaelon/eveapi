package com.beimin.eveapi.corporation.titles;


import com.beimin.eveapi.core.AbstractListParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.exception.ApiException;

public class CorporationTitlesParser extends AbstractListParser<CorporationTitlesHandler, CorporationTitlesResponse, ApiTitle> {
	public CorporationTitlesParser() {
		super(CorporationTitlesResponse.class, 2, ApiPath.CORPORATION, ApiPage.TITLES, CorporationTitlesHandler.class);
	}

	@Override
	public CorporationTitlesResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}