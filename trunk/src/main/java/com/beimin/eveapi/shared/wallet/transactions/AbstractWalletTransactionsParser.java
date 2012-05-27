package com.beimin.eveapi.shared.wallet.transactions;

import com.beimin.eveapi.core.*;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractWalletTransactionsParser extends AbstractListParser<WalletTransactionsHandler, WalletTransactionsResponse, ApiWalletTransaction> {
	public AbstractWalletTransactionsParser(ApiPath path) {
		super(WalletTransactionsResponse.class, 2, path, ApiPage.WALLET_TRANSACTIONS, WalletTransactionsHandler.class);
	}

	public WalletTransactionsResponse getResponse(ApiAuth<?> auth, int accountKey) throws ApiException {
		return getResponse(auth, "accountKey", Integer.toString(accountKey));
	}

	public WalletTransactionsResponse getResponse(ApiAuth<?> auth, int accountKey, long beforeTransID, int rowCount) throws ApiException {
		Map<String, String> extraParams = new HashMap<String, String>();
		extraParams.put("accountKey", Integer.toString(accountKey));
		extraParams.put("rowCount", Integer.toString(rowCount));
		extraParams.put("beforeTransID", Long.toString(beforeTransID));
		return getResponse(auth, extraParams);
	}
}