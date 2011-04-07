package com.beimin.eveapi.shared.wallet.transactions;

import java.util.HashMap;
import java.util.Map;

import com.beimin.eveapi.core.AbstractListParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

public abstract class AbstractWalletTransactionsParser extends AbstractListParser<WalletTransactionsResponse, ApiWalletTransaction> {
	public AbstractWalletTransactionsParser(ApiPath path) {
		super(WalletTransactionsResponse.class, 2, path, ApiPage.WALLET_TRANSACTIONS, ApiWalletTransaction.class);
	}

	public WalletTransactionsResponse getResponse(ApiAuth<?> auth, int accountKey) throws ApiException {
		return getResponse(auth, "accountKey", Integer.toString(accountKey));
	}

	public WalletTransactionsResponse getResponse(ApiAuth<?> auth, int accountKey, long beforeTransID) throws ApiException {
		Map<String, String> extraParams = new HashMap<String, String>();
		extraParams.put("accountKey", Integer.toString(accountKey));
		extraParams.put("beforeTransID", Long.toString(beforeTransID));
		return getResponse(auth, extraParams);
	}
}