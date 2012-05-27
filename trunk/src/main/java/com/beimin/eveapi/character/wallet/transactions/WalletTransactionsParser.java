package com.beimin.eveapi.character.wallet.transactions;

import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.shared.wallet.transactions.AbstractWalletTransactionsParser;
import com.beimin.eveapi.shared.wallet.transactions.WalletTransactionsResponse;

public class WalletTransactionsParser extends AbstractWalletTransactionsParser {
	private static final int DEFAULT_ROW_COUNT = 1000;

	private WalletTransactionsParser() {
		super(ApiPath.CHARACTER);
	}

	public static WalletTransactionsParser getInstance() {
		return new WalletTransactionsParser();
	}

	public WalletTransactionsResponse getTransactionsResponse(ApiAuth<?> auth) throws ApiException {
		return getResponse(auth, 1000);
	}

	public WalletTransactionsResponse getTransactionsResponse(ApiAuth<?> auth, long beforeTransID) throws ApiException {
		return getResponse(auth, 1000, beforeTransID, DEFAULT_ROW_COUNT);
	}

	public WalletTransactionsResponse getTransactionsResponse(ApiAuth<?> auth, long beforeTransID, int rowCount)
			throws ApiException {
		return getResponse(auth, 1000, beforeTransID, rowCount);
	}

}