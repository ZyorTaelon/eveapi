package com.beimin.eveapi.shared.wallet.transactions;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.digester.Digester;


import com.beimin.eveapi.core.AbstractApiParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

public abstract class AbstractWalletTransactionsParser extends AbstractApiParser<WalletTransactionsResponse> {
	public AbstractWalletTransactionsParser(ApiPath path) {
		super(WalletTransactionsResponse.class, 2, path, ApiPage.WALLET_TRANSACTIONS);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", ApiWalletTransaction.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addWalletTransaction");
		return digester;
	}

	public WalletTransactionsResponse getResponse(ApiAuth auth, int accountKey) throws ApiException {
		return getResponse(auth, "accountKey", Integer.toString(accountKey));
	}

	public WalletTransactionsResponse getResponse(ApiAuth auth, int accountKey, long beforeTransID) throws ApiException {
		Map<String, String> extraParams = new HashMap<String, String>();
		extraParams.put("accountKey", Integer.toString(accountKey));
		extraParams.put("beforeTransID", Long.toString(beforeTransID));
		return getResponse(auth, extraParams);
	}
}