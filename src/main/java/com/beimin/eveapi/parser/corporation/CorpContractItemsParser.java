package com.beimin.eveapi.parser.corporation;

import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractContractItemsParser;

public class CorpContractItemsParser extends AbstractContractItemsParser {
    public CorpContractItemsParser() {
        super(ApiPath.CORPORATION);
    }
}
