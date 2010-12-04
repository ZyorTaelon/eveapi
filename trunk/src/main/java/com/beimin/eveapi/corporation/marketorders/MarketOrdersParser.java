package com.beimin.eveapi.corporation.marketorders;

import com.beimin.eveapi.ApiPath;
import com.beimin.eveapi.shared.marketorders.AbstractMarketOrdersParser;

public class MarketOrdersParser extends AbstractMarketOrdersParser {
	private MarketOrdersParser() {
		super(ApiPath.CORPORATION);
	}

	public static MarketOrdersParser getInstance() {
		return new MarketOrdersParser();
	}
}