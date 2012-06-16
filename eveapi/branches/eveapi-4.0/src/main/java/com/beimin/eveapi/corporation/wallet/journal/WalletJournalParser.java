package com.beimin.eveapi.corporation.wallet.journal;

import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.shared.wallet.journal.AbstractWalletJournalParser;

public class WalletJournalParser extends AbstractWalletJournalParser {
	private WalletJournalParser() {
		super(ApiPath.CORPORATION);
	}

	public static WalletJournalParser getInstance() {
		return new WalletJournalParser();
	}
}