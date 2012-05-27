package com.beimin.eveapi.character.wallet.journal;

import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.shared.wallet.journal.AbstractWalletJournalParser;
import com.beimin.eveapi.shared.wallet.journal.WalletJournalResponse;

public class WalletJournalParser extends AbstractWalletJournalParser {
	private static final int DEFAULT_ROW_COUNT = 1000;

	private WalletJournalParser() {
		super(ApiPath.CHARACTER);
	}

	public static WalletJournalParser getInstance() {
		return new WalletJournalParser();
	}

	public WalletJournalResponse getWalletJournalResponse(ApiAuth<?> auth) throws ApiException {
		return getResponse(auth, 1000);
	}

	public WalletJournalResponse getWalletJournalResponse(ApiAuth<?> auth, long beforeRefID) throws ApiException {
		return getResponse(auth, 1000, beforeRefID, DEFAULT_ROW_COUNT);
	}

	public WalletJournalResponse getWalletJournalResponse(ApiAuth<?> auth, long beforeRefID, int rowCount)
			throws ApiException {
		return getResponse(auth, 1000, beforeRefID, rowCount);
	}

}