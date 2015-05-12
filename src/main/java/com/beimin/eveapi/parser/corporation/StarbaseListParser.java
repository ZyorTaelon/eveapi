package com.beimin.eveapi.parser.corporation;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.corporation.StarbaseListHandler;
import com.beimin.eveapi.model.corporation.Starbase;
import com.beimin.eveapi.parser.ApiAuth;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractListParser;
import com.beimin.eveapi.response.corporation.StarbaseListResponse;

public class StarbaseListParser extends AbstractListParser<StarbaseListHandler, StarbaseListResponse, Starbase> {
	public StarbaseListParser() {
		super(StarbaseListResponse.class, 2, ApiPath.CORPORATION, ApiPage.STARBASE_LIST, StarbaseListHandler.class);
	}

	@Override
	public StarbaseListResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}