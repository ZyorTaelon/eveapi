package com.beimin.eveapi.account.accountstatus;

import com.beimin.eveapi.core.AbstractApiParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.AbstractContentHandler;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.exception.ApiException;

public class AccountStatusParser extends AbstractApiParser<AccountStatusResponse> {
	public AccountStatusParser() {
		super(AccountStatusResponse.class, 2, ApiPath.ACCOUNT, ApiPage.ACCOUNT_STATUS);
	}

	@Override
	protected AbstractContentHandler getContentHandler() {
		return new AccountStatusHandler();
	}

	public static AccountStatusParser getInstance() {
		return new AccountStatusParser();
	}

	@Override
	public AccountStatusResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}