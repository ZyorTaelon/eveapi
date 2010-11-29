package com.beimin.eveapi.shared.marketorders;

import java.io.IOException;
import java.util.Collection;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;

public abstract class AbstractMarketOrdersParser extends AbstractApiParser<MarketOrdersResponse> {
	protected static final String MARKET_ORDERS_URL = "/MarketOrders";
	private final Path path;

	protected AbstractMarketOrdersParser(Path path) {
		super(MarketOrdersResponse.class, 2, MARKET_ORDERS_URL);
		this.path = path;
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", ApiMarketOrder.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addMarketOrder");
		return digester;
	}

	public MarketOrdersResponse getMarketOrdersResponse(ApiAuth auth) throws IOException, SAXException {
		return getResponse(auth, path);
	}
	
	public Collection<ApiMarketOrder> getMarketOrders(ApiAuth auth) throws IOException, SAXException {
		return getMarketOrdersResponse(auth).getMarketOrders();
	}
}