package com.beimin.eveapi.order;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuthorization;

public class Parser extends AbstractApiParser<Response> {
	protected static final String MARKET_ORDERS_URL = "/MarketOrders.xml.aspx";

	public Parser() {
		super(Response.class);
	}

	public Response getMarketOrders(ApiAuthorization auth, boolean corporation) throws IOException, SAXException {
		String url = EVE_API_URL;
		if (corporation)
			url += CORP_PATH;
		else
			url += CHAR_PATH;
		url += MARKET_ORDERS_URL;
		url += auth.getUrlParams();
		url += "&version=2";
		Response response = (Response) getDigester().parse(url);
		return response;
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		// TODO: Create Market Orders digester.
		return digester;
	}

	public static Parser getInstance() {
		return new Parser();
	}
}