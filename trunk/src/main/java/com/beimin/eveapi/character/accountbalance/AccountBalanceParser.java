package com.beimin.eveapi.character.accountbalance;

import com.beimin.eveapi.shared.accountbalance.AbstractAccountBalanceParser;

public class AccountBalanceParser extends AbstractAccountBalanceParser {
	
	private AccountBalanceParser() {
		super(Path.CHARACTER);
	}

	public static AccountBalanceParser getInstance() {
		return new AccountBalanceParser();
	}
}