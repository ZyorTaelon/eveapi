package com.beimin.eveapi.parser.account;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.AbstractContentHandler;
import com.beimin.eveapi.handler.account.AccountStatusHandler;
import com.beimin.eveapi.parser.ApiAuth;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractApiParser;
import com.beimin.eveapi.response.account.AccountStatusResponse;

public class AccountStatusParser extends AbstractApiParser<AccountStatusResponse> {
	public AccountStatusParser() {
		super(AccountStatusResponse.class, 2, ApiPath.ACCOUNT, ApiPage.ACCOUNT_STATUS);
	}

	@Override
	protected AbstractContentHandler getContentHandler() {
		return new AccountStatusHandler();
	}

	@Override
	public AccountStatusResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}