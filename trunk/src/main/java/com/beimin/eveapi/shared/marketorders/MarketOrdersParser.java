package com.beimin.eveapi.shared.marketorders;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;

public class MarketOrdersParser extends AbstractApiParser<MarketOrdersResponse> {
	protected static final String MARKET_ORDERS_URL = "/MarketOrders.xml.aspx";

	public MarketOrdersParser() {
		super(MarketOrdersResponse.class, 2, MARKET_ORDERS_URL);
	}

	public MarketOrdersResponse getMarketOrders(ApiAuth auth, boolean corporation) throws IOException, SAXException {
		if (corporation)
			return getResponse(auth, Path.CORP);
		return getResponse(auth, Path.CHARACTER);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", ApiMarketOrder.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addMarketOrder");
		return digester;
	}

	public static MarketOrdersParser getInstance() {
		return new MarketOrdersParser();
	}
}