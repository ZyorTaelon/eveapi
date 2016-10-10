package com.beimin.eveapi.parser.corporation;

import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractContractBidsParser;

public class CorpContractBidsParser extends AbstractContractBidsParser {
    public CorpContractBidsParser() {
        super(ApiPath.CORPORATION);
    }
}
