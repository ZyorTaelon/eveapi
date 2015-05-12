package com.beimin.eveapi.parser.eve;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.eve.ErrorListHandler;
import com.beimin.eveapi.model.corporation.ErrorListItem;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractListParser;
import com.beimin.eveapi.response.eve.ErrorListResponse;

public class ErrorListParser extends AbstractListParser<ErrorListHandler, ErrorListResponse, ErrorListItem> {
	public ErrorListParser() {
		super(ErrorListResponse.class, 2, ApiPath.EVE, ApiPage.ERROR_LIST, ErrorListHandler.class);
	}

	@Override
	public ErrorListResponse getResponse() throws ApiException {
		return super.getResponse();
	}
}