package com.beimin.eveapi.eve.reftypes;


import com.beimin.eveapi.core.AbstractListParser;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

public class RefTypesParser extends AbstractListParser<RefTypesResponse, ApiRefType> {
	public RefTypesParser() {
		super(RefTypesResponse.class, 1, ApiPath.EVE, ApiPage.REF_TYPES, ApiRefType.class);
	}

	public static RefTypesParser getInstance() {
		return new RefTypesParser();
	}

	@Override
	public RefTypesResponse getResponse() throws ApiException {
		return super.getResponse();
	}
}