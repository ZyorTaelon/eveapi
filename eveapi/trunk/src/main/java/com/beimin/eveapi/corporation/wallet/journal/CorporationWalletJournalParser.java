package com.beimin.eveapi.corporation.wallet.journal;

import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.shared.wallet.journal.AbstractWalletJournalParser;

public class CorporationWalletJournalParser extends AbstractWalletJournalParser {
	public CorporationWalletJournalParser() {
		super(ApiPath.CORPORATION);
	}
}