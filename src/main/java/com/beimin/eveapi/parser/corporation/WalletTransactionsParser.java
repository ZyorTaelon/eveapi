package com.beimin.eveapi.parser.corporation;

import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractWalletTransactionsParser;

public class WalletTransactionsParser extends AbstractWalletTransactionsParser {
	public WalletTransactionsParser() {
		super(ApiPath.CORPORATION);
	}
}