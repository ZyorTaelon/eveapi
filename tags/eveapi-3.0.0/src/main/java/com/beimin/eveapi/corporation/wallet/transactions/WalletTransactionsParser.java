package com.beimin.eveapi.corporation.wallet.transactions;

import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.shared.wallet.transactions.AbstractWalletTransactionsParser;

public class WalletTransactionsParser extends AbstractWalletTransactionsParser {
	private WalletTransactionsParser() {
		super(ApiPath.CORPORATION);
	}

	public static WalletTransactionsParser getInstance() {
		return new WalletTransactionsParser();
	}
}