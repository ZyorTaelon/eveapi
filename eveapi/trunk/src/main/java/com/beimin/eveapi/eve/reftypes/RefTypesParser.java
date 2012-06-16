package com.beimin.eveapi.eve.reftypes;

import com.beimin.eveapi.core.AbstractListParser;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.exception.ApiException;

public class RefTypesParser extends AbstractListParser<RefTypesHandler, RefTypesResponse, ApiRefType> {
	public RefTypesParser() {
		super(RefTypesResponse.class, 1, ApiPath.EVE, ApiPage.REF_TYPES, RefTypesHandler.class);
	}

	public static RefTypesParser getInstance() {
		return new RefTypesParser();
	}

	@Override
	public RefTypesResponse getResponse() throws ApiException {
		return super.getResponse();
	}
}