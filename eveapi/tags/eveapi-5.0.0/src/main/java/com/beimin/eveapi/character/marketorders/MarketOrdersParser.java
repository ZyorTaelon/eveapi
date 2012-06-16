package com.beimin.eveapi.character.marketorders;

import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.shared.marketorders.AbstractMarketOrdersParser;

public class MarketOrdersParser extends AbstractMarketOrdersParser {
	private MarketOrdersParser() {
		super(ApiPath.CHARACTER);
	}

	public static MarketOrdersParser getInstance() {
		return new MarketOrdersParser();
	}
}