package com.beimin.eveapi.balance;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;

public class Parser extends AbstractApiParser<Response> {
	protected static final String ACCOUNTBALANCE_URL = "/AccountBalance.xml.aspx";

	public Parser() {
		super(Response.class, 1, ACCOUNTBALANCE_URL);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", ApiAccountBalance.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addAccountBalance");
		return digester;
	}

	public Response getAccountBalance(ApiAuth auth, boolean corporation) throws IOException, SAXException {
		if (corporation)
			return getResponse(auth, Path.CORP);
		return getResponse(auth, Path.CHARACTER);
	}

	public static Parser getInstance() {
		return new Parser();
	}
}