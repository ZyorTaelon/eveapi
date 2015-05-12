package com.beimin.eveapi.parser.account;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.AbstractContentHandler;
import com.beimin.eveapi.handler.account.ApiKeyInfoHandler;
import com.beimin.eveapi.parser.ApiAuth;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractApiParser;
import com.beimin.eveapi.response.account.ApiKeyInfoResponse;


public class ApiKeyInfoParser extends AbstractApiParser<ApiKeyInfoResponse> {
	public ApiKeyInfoParser() {
		super(ApiKeyInfoResponse.class, 2, ApiPath.ACCOUNT, ApiPage.API_KEY_INFO);
	}

	@Override
	protected AbstractContentHandler getContentHandler() {
		return new ApiKeyInfoHandler();
	}

	@Override
	public ApiKeyInfoResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}
