package com.beimin.eveapi.corporation.wallet.journal;

import com.beimin.eveapi.shared.wallet.journal.AbstractWalletJournalParser;

public class WalletJournalParser extends AbstractWalletJournalParser{

	private WalletJournalParser() {
		super(Path.CORPORATION);
	}

	public static WalletJournalParser getInstance() {
		return new WalletJournalParser();
	}
}