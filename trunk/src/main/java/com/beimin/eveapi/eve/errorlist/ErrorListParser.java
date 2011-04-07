package com.beimin.eveapi.eve.errorlist;


import com.beimin.eveapi.core.AbstractListParser;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

public class ErrorListParser extends AbstractListParser<ErrorListResponse, ApiErrorListItem> {
	public ErrorListParser() {
		super(ErrorListResponse.class, 2, ApiPath.EVE, ApiPage.ERROR_LIST, ApiErrorListItem.class);
	}

	public static ErrorListParser getInstance() {
		return new ErrorListParser();
	}

	@Override
	public ErrorListResponse getResponse() throws ApiException {
		return super.getResponse();
	}
}