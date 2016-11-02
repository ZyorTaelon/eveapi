package com.beimin.eveapi.parser.character;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.parser.ApiAuth;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractWalletTransactionsParser;
import com.beimin.eveapi.response.shared.WalletTransactionsResponse;

public class CharWalletTransactionsParser extends AbstractWalletTransactionsParser {
    private static final int DEFAULT_ROW_COUNT = 1000;

    public CharWalletTransactionsParser() {
        super(ApiPath.CHARACTER);
    }

    public WalletTransactionsResponse getTransactionsResponse(final ApiAuth auth) throws ApiException {
        return getResponse(auth, 1000);
    }

    public WalletTransactionsResponse getTransactionsResponse(final ApiAuth auth, final long beforeTransID) throws ApiException {
        return getResponse(auth, 1000, beforeTransID, DEFAULT_ROW_COUNT);
    }

    public WalletTransactionsResponse getTransactionsResponse(final ApiAuth auth, final long beforeTransID, final int rowCount) throws ApiException {
        return getResponse(auth, 1000, beforeTransID, rowCount);
    }

}
