package com.beimin.eveapi.parser.character;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.parser.ApiAuth;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractWalletJournalParser;
import com.beimin.eveapi.response.shared.WalletJournalResponse;

public class CharWalletJournalParser extends AbstractWalletJournalParser {
    private static final int DEFAULT_ROW_COUNT = 1000;

    public CharWalletJournalParser() {
        super(ApiPath.CHARACTER);
    }

    public WalletJournalResponse getWalletJournalResponse(final ApiAuth auth) throws ApiException {
        return getResponse(auth, 1000);
    }

    public WalletJournalResponse getWalletJournalResponse(final ApiAuth auth, final long beforeRefID) throws ApiException {
        return getResponse(auth, 1000, beforeRefID, DEFAULT_ROW_COUNT);
    }

    public WalletJournalResponse getWalletJournalResponse(final ApiAuth auth, final long beforeRefID, final int rowCount) throws ApiException {
        return getResponse(auth, 1000, beforeRefID, rowCount);
    }
}
