package com.beimin.eveapi.transaction;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;

public class Parser extends AbstractApiParser<Response> {
	protected static final String TRANSACTIONS_URL = "/WalletTransactions.xml.aspx";

	public Parser() {
		super(Response.class, 2, TRANSACTIONS_URL);
	}

	public Response getTransactions(ApiAuth auth, boolean corporation, Integer accountKey, Long beforeTransID) throws IOException, SAXException {
		if (corporation) {
			Map<String, String> extraParams = new HashMap<String, String>();
			if (beforeTransID!=null) {
				extraParams.put("beforeTransID", beforeTransID.toString());
			}
			if (accountKey!=null) {
				extraParams.put("accountKey", accountKey.toString());
			}
			if(extraParams.size() > 0) {
				return getResponse(auth, Path.CORP, extraParams);	
			}
			return getResponse(auth, Path.CORP);
		}
		return getResponse(auth, Path.CHARACTER);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", ApiWalletTransaction.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addWalletTransaction");
		return digester;
	}

	public static Parser getInstance() {
		return new Parser();
	}
}