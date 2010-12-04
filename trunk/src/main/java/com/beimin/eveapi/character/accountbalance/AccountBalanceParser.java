package com.beimin.eveapi.character.accountbalance;

import com.beimin.eveapi.ApiPath;
import com.beimin.eveapi.shared.accountbalance.AbstractAccountBalanceParser;

public class AccountBalanceParser extends AbstractAccountBalanceParser {
	private AccountBalanceParser() {
		super(ApiPath.CHARACTER);
	}

	public static AccountBalanceParser getInstance() {
		return new AccountBalanceParser();
	}
}