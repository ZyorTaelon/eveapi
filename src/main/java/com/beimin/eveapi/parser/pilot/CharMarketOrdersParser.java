package com.beimin.eveapi.parser.pilot;

import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractMarketOrdersParser;

public class CharMarketOrdersParser extends AbstractMarketOrdersParser {
    public CharMarketOrdersParser() {
        super(ApiPath.CHARACTER);
    }
}
