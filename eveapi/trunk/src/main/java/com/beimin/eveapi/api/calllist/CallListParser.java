package com.beimin.eveapi.api.calllist;

import com.beimin.eveapi.core.AbstractApiParser;
import com.beimin.eveapi.core.AbstractContentHandler;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.exception.ApiException;

public class CallListParser extends AbstractApiParser<CallListResponse> {
	public CallListParser() {
		super(CallListResponse.class, 2, ApiPath.API, ApiPage.CALL_LIST);
	}

	@Override
	protected AbstractContentHandler getContentHandler() {
		return new CallListHandler();
	}

	@Override
	public CallListResponse getResponse() throws ApiException {
		return super.getResponse();
	}
}