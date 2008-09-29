package com.beimin.eveapi.balance;

import java.util.Collection;
import java.util.HashSet;

import com.beimin.eveapi.ApiResponse;

public class Response extends ApiResponse {
	private final Collection<AccountBalance> accountBalances = new HashSet<AccountBalance>();

	public void addAccountBalance(AccountBalance accountBalance) {
		accountBalances.add(accountBalance);
	}

	public Collection<AccountBalance> getAccountBalances() {
		return accountBalances;
	}
}
