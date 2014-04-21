package com.beimin.eveapi.parser.eve;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.eve.RefTypesHandler;
import com.beimin.eveapi.model.eve.RefType;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractListParser;
import com.beimin.eveapi.response.eve.RefTypesResponse;

public class RefTypesParser extends AbstractListParser<RefTypesHandler, RefTypesResponse, RefType> {
	public RefTypesParser() {
		super(RefTypesResponse.class, 1, ApiPath.EVE, ApiPage.REF_TYPES, RefTypesHandler.class);
	}

	@Override
	public RefTypesResponse getResponse() throws ApiException {
		return super.getResponse();
	}
}