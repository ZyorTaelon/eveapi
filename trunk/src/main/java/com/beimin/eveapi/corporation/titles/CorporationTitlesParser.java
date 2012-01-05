package com.beimin.eveapi.corporation.titles;


import com.beimin.eveapi.core.AbstractListParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

public class CorporationTitlesParser extends AbstractListParser<CorporationTitlesHandler, CorporationTitlesResponse, ApiTitle> {
	public CorporationTitlesParser() {
		super(CorporationTitlesResponse.class, 2, ApiPath.CORPORATION, ApiPage.TITLES, CorporationTitlesHandler.class);
	}

	public static CorporationTitlesParser getInstance() {
		return new CorporationTitlesParser();
	}

	@Override
	public CorporationTitlesResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}