package com.beimin.eveapi.corporation.marketorders;

import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.shared.marketorders.AbstractMarketOrdersParser;

public class CorporationMarketOrdersParser extends AbstractMarketOrdersParser {
	public CorporationMarketOrdersParser() {
		super(ApiPath.CORPORATION);
	}
}