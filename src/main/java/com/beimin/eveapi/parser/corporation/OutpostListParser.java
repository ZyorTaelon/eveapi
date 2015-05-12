package com.beimin.eveapi.parser.corporation;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.corporation.OutpostListHandler;
import com.beimin.eveapi.model.corporation.Outpost;
import com.beimin.eveapi.parser.ApiAuth;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractListParser;
import com.beimin.eveapi.response.corporation.OutpostListResponse;

public class OutpostListParser extends AbstractListParser<OutpostListHandler, OutpostListResponse, Outpost> {
	public OutpostListParser() {
		super(OutpostListResponse.class, 2, ApiPath.CORPORATION, ApiPage.OUTPOST_LIST, OutpostListHandler.class);
	}

	@Override
	public OutpostListResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}