package com.beimin.eveapi.transaction;

import java.util.ArrayList;
import java.util.List;

import com.beimin.eveapi.ApiResponse;

public class Response extends ApiResponse {
	private final List<ApiWalletTransaction> walletTransactions = new ArrayList<ApiWalletTransaction>();

	public void addWalletTransaction(ApiWalletTransaction walletTransaction) {
		walletTransactions.add(walletTransaction);
	}

	public List<ApiWalletTransaction> getWalletTransactions() {
		return walletTransactions;
	}
}