package com.beimin.eveapi.corporation.accountbalance;

import com.beimin.eveapi.ApiPath;
import com.beimin.eveapi.shared.accountbalance.AbstractAccountBalanceParser;

public class AccountBalanceParser extends AbstractAccountBalanceParser {
	private AccountBalanceParser() {
		super(ApiPath.CORPORATION);
	}

	public static AccountBalanceParser getInstance() {
		return new AccountBalanceParser();
	}
}