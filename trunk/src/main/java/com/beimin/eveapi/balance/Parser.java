package com.beimin.eveapi.balance;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;

public class Parser extends AbstractApiParser<Response> {
	protected static final String ACCOUNTBALANCE_URL = "/AccountBalance.xml.aspx";

	public Parser() {
		super(Response.class);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", AccountBalance.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addAccountBalance");
		return digester;
	}

	public Response getAccountBalance(ApiAuth auth, boolean corporation) throws IOException, SAXException {
		String requestUrl = EVE_API_URL;
		if (corporation)
			requestUrl += CORP_PATH;
		else
			requestUrl += CHAR_PATH;
		requestUrl += ACCOUNTBALANCE_URL;
		requestUrl += auth.getUrlParams();
		requestUrl += "&version=1";
		return getResponse(requestUrl, getDigester());
	}

	public static Parser getInstance() {
		return new Parser();
	}
}