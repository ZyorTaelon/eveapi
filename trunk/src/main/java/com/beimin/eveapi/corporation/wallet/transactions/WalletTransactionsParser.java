package com.beimin.eveapi.corporation.wallet.transactions;

import com.beimin.eveapi.shared.wallet.transactions.AbstractWalletTransactionsParser;

public class WalletTransactionsParser extends AbstractWalletTransactionsParser{

	private WalletTransactionsParser() {
		super(Path.CORPORATION);
	}

	public static WalletTransactionsParser getInstance() {
		return new WalletTransactionsParser();
	}
}