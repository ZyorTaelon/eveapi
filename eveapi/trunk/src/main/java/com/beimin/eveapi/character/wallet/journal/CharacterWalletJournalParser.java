package com.beimin.eveapi.character.wallet.journal;

import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.shared.wallet.journal.AbstractWalletJournalParser;
import com.beimin.eveapi.shared.wallet.journal.WalletJournalResponse;

public class CharacterWalletJournalParser extends AbstractWalletJournalParser {
	private static final int DEFAULT_ROW_COUNT = 1000;

	public CharacterWalletJournalParser() {
		super(ApiPath.CHARACTER);
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