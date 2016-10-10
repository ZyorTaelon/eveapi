package com.beimin.eveapi.parser.corporation;

import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractMarketOrdersParser;

public class CorpMarketOrdersParser extends AbstractMarketOrdersParser {
    public CorpMarketOrdersParser() {
        super(ApiPath.CORPORATION);
    }
}
