package com.beimin.eveapi.eve.errorlist;

import com.beimin.eveapi.core.AbstractListParser;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.exception.ApiException;

public class ErrorListParser extends AbstractListParser<ErrorListHandler, ErrorListResponse, ApiErrorListItem> {
	public ErrorListParser() {
		super(ErrorListResponse.class, 2, ApiPath.EVE, ApiPage.ERROR_LIST, ErrorListHandler.class);
	}

	public static ErrorListParser getInstance() {
		return new ErrorListParser();
	}

	@Override
	public ErrorListResponse getResponse() throws ApiException {
		return super.getResponse();
	}
}