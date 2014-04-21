package com.beimin.eveapi.parser.corporation;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.parser.ApiAuth;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractAccountBalanceParser;
import com.beimin.eveapi.response.shared.AccountBalanceResponse;

public class AccountBalanceParser extends AbstractAccountBalanceParser {
	public AccountBalanceParser() {
		super(ApiPath.CORPORATION);
	}

	@Override
	public AccountBalanceResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}