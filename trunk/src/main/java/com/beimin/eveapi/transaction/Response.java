package com.beimin.eveapi.transaction;

import java.util.ArrayList;
import java.util.Collection;

import com.beimin.eveapi.ApiResponse;

public class Response extends ApiResponse {
	private final Collection<WalletTransaction> walletTransactions = new ArrayList<WalletTransaction>();

	public void addWalletTransaction(WalletTransaction walletTransaction) {
		walletTransactions.add(walletTransaction);
	}

	public Collection<WalletTransaction> getWalletTransactions() {
		return walletTransactions;
	}
}