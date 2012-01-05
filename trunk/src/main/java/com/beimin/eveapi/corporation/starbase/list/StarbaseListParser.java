package com.beimin.eveapi.corporation.starbase.list;

import com.beimin.eveapi.core.AbstractListParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

public class StarbaseListParser extends AbstractListParser<StarbaseListHandler, StarbaseListResponse, ApiStarbase> {
	public StarbaseListParser() {
		super(StarbaseListResponse.class, 2, ApiPath.CORPORATION, ApiPage.STARBASE_LIST, StarbaseListHandler.class);
	}

	public static StarbaseListParser getInstance() {
		return new StarbaseListParser();
	}

	@Override
	public StarbaseListResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}