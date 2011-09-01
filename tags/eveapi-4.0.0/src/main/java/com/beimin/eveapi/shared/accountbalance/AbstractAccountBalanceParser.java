package com.beimin.eveapi.shared.accountbalance;

import com.beimin.eveapi.core.AbstractListParser;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

public abstract class AbstractAccountBalanceParser extends AbstractListParser<AccountBalanceResponse, EveAccountBalance> {
	protected AbstractAccountBalanceParser(ApiPath path) {
		super(AccountBalanceResponse.class, 2, path, ApiPage.ACCOUNT_BALANCE, EveAccountBalance.class);
	}
}