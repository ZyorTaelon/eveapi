package com.beimin.eveapi.shared.marketorders;

import com.beimin.eveapi.core.AbstractListParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.exception.ApiException;

public abstract class AbstractMarketOrdersParser extends AbstractListParser<MarketOrdersHandler, MarketOrdersResponse, ApiMarketOrder> {
	protected AbstractMarketOrdersParser(ApiPath path) {
		super(MarketOrdersResponse.class, 2, path, ApiPage.MARKET_ORDERS, MarketOrdersHandler.class);
	}

	@Override
	public MarketOrdersResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}