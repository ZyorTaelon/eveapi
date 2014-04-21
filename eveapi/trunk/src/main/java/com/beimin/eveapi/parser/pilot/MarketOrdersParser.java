package com.beimin.eveapi.parser.pilot;

import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractMarketOrdersParser;

public class MarketOrdersParser extends AbstractMarketOrdersParser {
	public MarketOrdersParser() {
		super(ApiPath.CHARACTER);
	}
}