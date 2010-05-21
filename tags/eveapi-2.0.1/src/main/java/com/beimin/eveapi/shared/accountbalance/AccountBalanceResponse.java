package com.beimin.eveapi.shared.accountbalance;

import java.util.Collection;
import java.util.HashSet;

import com.beimin.eveapi.ApiResponse;

public class AccountBalanceResponse extends ApiResponse {
	private final Collection<ApiAccountBalance> accountBalances = new HashSet<ApiAccountBalance>();

	public void addAccountBalance(ApiAccountBalance accountBalance) {
		accountBalances.add(accountBalance);
	}

	public Collection<ApiAccountBalance> getAccountBalances() {
		return accountBalances;
	}
}