package com.beimin.eveapi.corporation.wallet.transactions;

import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.shared.wallet.transactions.AbstractWalletTransactionsParser;

public class CorporationWalletTransactionsParser extends AbstractWalletTransactionsParser {
	public CorporationWalletTransactionsParser() {
		super(ApiPath.CORPORATION);
	}
}