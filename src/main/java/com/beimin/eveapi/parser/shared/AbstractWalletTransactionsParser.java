package com.beimin.eveapi.parser.shared;

import java.util.HashMap;
import java.util.Map;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.shared.WalletTransactionsHandler;
import com.beimin.eveapi.model.shared.WalletTransaction;
import com.beimin.eveapi.parser.ApiAuth;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.response.shared.WalletTransactionsResponse;

public abstract class AbstractWalletTransactionsParser extends AbstractListParser<WalletTransactionsHandler, WalletTransactionsResponse, WalletTransaction> {
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