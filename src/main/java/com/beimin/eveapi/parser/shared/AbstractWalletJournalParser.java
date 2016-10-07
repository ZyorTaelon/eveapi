package com.beimin.eveapi.parser.shared;

import java.util.HashMap;
import java.util.Map;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.shared.WalletJournalHandler;
import com.beimin.eveapi.model.shared.JournalEntry;
import com.beimin.eveapi.parser.ApiAuth;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.response.shared.WalletJournalResponse;

public abstract class AbstractWalletJournalParser extends AbstractListParser<WalletJournalHandler, WalletJournalResponse, JournalEntry> {
    public AbstractWalletJournalParser(final ApiPath path) {
        super(WalletJournalResponse.class, 2, path, ApiPage.WALLET_JOURNAL, WalletJournalHandler.class);
    }

    public WalletJournalResponse getResponse(final ApiAuth auth, final int accountKey) throws ApiException {
        return getResponse(auth, "accountKey", Integer.toString(accountKey));
    }

    public WalletJournalResponse getResponse(final ApiAuth auth, final Integer accountKey, final Long beforeRefID, final int rowCount) throws ApiException {
        final Map<String, String> extraParams = new HashMap<String, String>();
        if (accountKey != null) {
            extraParams.put("accountKey", Integer.toString(accountKey));
        }
        extraParams.put("rowCount", Integer.toString(rowCount));
        if (beforeRefID != null) {
            extraParams.put("beforeRefID", Long.toString(beforeRefID));
        }
        return getResponse(auth, extraParams);
    }
}