package com.beimin.eveapi.parser.calllist;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.AbstractContentHandler;
import com.beimin.eveapi.handler.calllist.CallListHandler;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractApiParser;
import com.beimin.eveapi.response.calllist.CallListResponse;

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