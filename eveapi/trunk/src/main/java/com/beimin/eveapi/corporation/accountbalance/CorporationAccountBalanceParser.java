package com.beimin.eveapi.corporation.accountbalance;

import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.shared.accountbalance.AbstractAccountBalanceParser;
import com.beimin.eveapi.shared.accountbalance.AccountBalanceResponse;

public class CorporationAccountBalanceParser extends AbstractAccountBalanceParser {
	public CorporationAccountBalanceParser() {
		super(ApiPath.CORPORATION);
	}

	@Override
	public AccountBalanceResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}