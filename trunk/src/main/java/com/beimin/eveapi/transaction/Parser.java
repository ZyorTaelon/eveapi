package com.beimin.eveapi.transaction;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuthorization;

public class Parser extends AbstractApiParser<Response> {
	protected static final String TRANSACTIONS_URL = "/WalletTransactions.xml.aspx";

	public Parser() {
		super(Response.class);
	}

	public Response getTransactions(ApiAuthorization auth, boolean corporation) throws IOException, SAXException {
		String url = EVE_API_URL;
		if (corporation)
			url += CORP_PATH;
		else
			url += CHAR_PATH;
		url += TRANSACTIONS_URL;
		url += auth.getUrlParams();
		url += "&version=2";
		Response response = (Response) getDigester().parse(url);
		return response;
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		// TODO: Create Market Transactions digester.
		return digester;
	}

	public static Parser getInstance() {
		return new Parser();
	}
}