package com.beimin.eveapi.shared.marketorders;


import org.apache.commons.digester.Digester;


import com.beimin.eveapi.core.AbstractApiParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

public abstract class AbstractMarketOrdersParser extends AbstractApiParser<MarketOrdersResponse> {
	protected AbstractMarketOrdersParser(ApiPath path) {
		super(MarketOrdersResponse.class, 2, path, ApiPage.MARKET_ORDERS);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", ApiMarketOrder.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addMarketOrder");
		return digester;
	}

	@Override
	public MarketOrdersResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}