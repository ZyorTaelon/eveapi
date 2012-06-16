package com.beimin.eveapi.corporation.accountbalance;

import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.shared.accountbalance.AbstractAccountBalanceParser;
import com.beimin.eveapi.shared.accountbalance.AccountBalanceResponse;

public class AccountBalanceParser extends AbstractAccountBalanceParser {
	private AccountBalanceParser() {
		super(ApiPath.CORPORATION);
	}

	public static AccountBalanceParser getInstance() {
		return new AccountBalanceParser();
	}

	@Override
	public AccountBalanceResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}