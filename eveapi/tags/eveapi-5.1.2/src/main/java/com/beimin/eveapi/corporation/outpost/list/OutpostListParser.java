package com.beimin.eveapi.corporation.outpost.list;

import com.beimin.eveapi.core.AbstractListParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.exception.ApiException;

public class OutpostListParser extends AbstractListParser<OutpostListHandler, OutpostListResponse, ApiOutpost> {
	public OutpostListParser() {
		super(OutpostListResponse.class, 2, ApiPath.CORPORATION, ApiPage.OUTPOST_LIST, OutpostListHandler.class);
	}

	public static OutpostListParser getInstance() {
		return new OutpostListParser();
	}

	@Override
	public OutpostListResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}