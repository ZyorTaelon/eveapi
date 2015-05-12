package com.beimin.eveapi.parser.corporation;


import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.corporation.TitlesHandler;
import com.beimin.eveapi.model.corporation.Title;
import com.beimin.eveapi.parser.ApiAuth;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractListParser;
import com.beimin.eveapi.response.corporation.TitlesResponse;

public class TitlesParser extends AbstractListParser<TitlesHandler, TitlesResponse, Title> {
	public TitlesParser() {
		super(TitlesResponse.class, 2, ApiPath.CORPORATION, ApiPage.TITLES, TitlesHandler.class);
	}

	@Override
	public TitlesResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}