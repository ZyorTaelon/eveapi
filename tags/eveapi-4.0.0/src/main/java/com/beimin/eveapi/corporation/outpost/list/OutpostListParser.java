package com.beimin.eveapi.corporation.outpost.list;


import com.beimin.eveapi.core.AbstractListParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

public class OutpostListParser extends AbstractListParser<OutpostListResponse, ApiOutpost> {
	public OutpostListParser() {
		super(OutpostListResponse.class, 2, ApiPath.CORPORATION, ApiPage.OUTPOST_LIST, ApiOutpost.class);
	}


	public static OutpostListParser getInstance() {
		return new OutpostListParser();
	}

	@Override
	public OutpostListResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}