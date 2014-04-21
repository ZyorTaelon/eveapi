package com.beimin.eveapi.parser.corporation;

import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractWalletJournalParser;

public class WalletJournalParser extends AbstractWalletJournalParser {
	public WalletJournalParser() {
		super(ApiPath.CORPORATION);
	}
}