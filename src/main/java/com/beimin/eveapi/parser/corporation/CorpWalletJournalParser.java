package com.beimin.eveapi.parser.corporation;

import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractWalletJournalParser;

public class CorpWalletJournalParser extends AbstractWalletJournalParser {
    public CorpWalletJournalParser() {
        super(ApiPath.CORPORATION);
    }
}
