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

public abstract class AbstractWalletJournalParser extends
		AbstractListParser<WalletJournalHandler, WalletJournalResponse, JournalEntry> {
	public AbstractWalletJournalParser(ApiPath path) {
		super(WalletJournalResponse.class, 2, path, ApiPage.WALLET_JOURNAL, WalletJournalHandler.class);
	}

	public WalletJournalResponse getResponse(ApiAuth<?> auth, int accountKey) throws ApiException {
		return getResponse(auth, "accountKey", Integer.toString(accountKey));
	}

	public WalletJournalResponse getResponse(ApiAuth<?> auth, int accountKey, long beforeRefID, int rowCount)
			throws ApiException {
		Map<String, String> extraParams = new HashMap<String, String>();
		extraParams.put("accountKey", Integer.toString(accountKey));
		extraParams.put("rowCount", Integer.toString(rowCount));
		extraParams.put("beforeRefID", Long.toString(beforeRefID));
		return getResponse(auth, extraParams);
	}
}