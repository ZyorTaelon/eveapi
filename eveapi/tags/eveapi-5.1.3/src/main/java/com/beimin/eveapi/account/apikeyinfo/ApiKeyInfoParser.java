package com.beimin.eveapi.account.apikeyinfo;

import com.beimin.eveapi.core.AbstractApiParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.AbstractContentHandler;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.exception.ApiException;


public class ApiKeyInfoParser extends AbstractApiParser<ApiKeyInfoResponse> {
	public ApiKeyInfoParser() {
		super(ApiKeyInfoResponse.class, 2, ApiPath.ACCOUNT, ApiPage.API_KEY_INFO);
	}

	@Override
	protected AbstractContentHandler getContentHandler() {
		return new ApiKeyInfoHandler();
	}

	public static ApiKeyInfoParser getInstance() {
		return new ApiKeyInfoParser();
	}

	@Override
	public ApiKeyInfoResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}
