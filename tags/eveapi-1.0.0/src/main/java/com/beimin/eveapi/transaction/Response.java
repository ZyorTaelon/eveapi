package com.beimin.eveapi.transaction;

import java.util.ArrayList;
import java.util.Collection;

import com.beimin.eveapi.ApiResponse;

public class Response extends ApiResponse {
	private final Collection<ApiWalletTransaction> walletTransactions = new ArrayList<ApiWalletTransaction>();

	public void addWalletTransaction(ApiWalletTransaction walletTransaction) {
		walletTransactions.add(walletTransaction);
	}

	public Collection<ApiWalletTransaction> getWalletTransactions() {
		return walletTransactions;
	}
}