package com.beimin.eveapi.shared.accountbalance;

import java.util.Collection;
import java.util.HashSet;

import com.beimin.eveapi.core.ApiResponse;

public class AccountBalanceResponse extends ApiResponse {
	private static final long serialVersionUID = 1L;
	private final Collection<ApiAccountBalance> accountBalances = new HashSet<ApiAccountBalance>();

	public void addAccountBalance(ApiAccountBalance accountBalance) {
		accountBalances.add(accountBalance);
	}

	public Collection<ApiAccountBalance> getAccountBalances() {
		return accountBalances;
	}
}