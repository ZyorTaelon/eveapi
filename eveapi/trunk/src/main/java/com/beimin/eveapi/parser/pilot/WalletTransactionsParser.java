package com.beimin.eveapi.parser.pilot;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.parser.ApiAuth;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractWalletTransactionsParser;
import com.beimin.eveapi.response.shared.WalletTransactionsResponse;

public class WalletTransactionsParser extends AbstractWalletTransactionsParser {
	private static final int DEFAULT_ROW_COUNT = 1000;

	public WalletTransactionsParser() {
		super(ApiPath.CHARACTER);
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