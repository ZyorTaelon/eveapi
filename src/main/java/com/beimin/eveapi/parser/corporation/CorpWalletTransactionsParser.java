package com.beimin.eveapi.parser.corporation;

import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractWalletTransactionsParser;

public class CorpWalletTransactionsParser extends AbstractWalletTransactionsParser {
    public CorpWalletTransactionsParser() {
        super(ApiPath.CORPORATION);
    }
}
