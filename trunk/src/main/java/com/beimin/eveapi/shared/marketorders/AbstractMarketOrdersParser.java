package com.beimin.eveapi.shared.marketorders;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;
import com.beimin.eveapi.ApiPage;
import com.beimin.eveapi.ApiPath;

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
	public MarketOrdersResponse getResponse(ApiAuth auth) throws IOException, SAXException {
		return super.getResponse(auth);
	}
}