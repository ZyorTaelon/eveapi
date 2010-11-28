package com.beimin.eveapi.corporation.accountbalance;

import com.beimin.eveapi.shared.accountbalance.AbstractAccountBalanceParser;

public class AccountBalanceParser extends AbstractAccountBalanceParser {
	
	private AccountBalanceParser() {
		super(Path.CORPORATION);
	}

	public static AccountBalanceParser getInstance() {
		return new AccountBalanceParser();
	}
}