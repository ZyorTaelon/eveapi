package com.beimin.eveapi.parser.shared;

import com.beimin.eveapi.handler.shared.AccountBalanceHandler;
import com.beimin.eveapi.model.shared.EveAccountBalance;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.response.shared.AccountBalanceResponse;

public abstract class AbstractAccountBalanceParser extends AbstractListParser<AccountBalanceHandler, AccountBalanceResponse, EveAccountBalance> {
	protected AbstractAccountBalanceParser(ApiPath path) {
		super(AccountBalanceResponse.class, 2, path, ApiPage.ACCOUNT_BALANCE, AccountBalanceHandler.class);
	}
}