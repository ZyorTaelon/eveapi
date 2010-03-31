package com.beimin.eveapi.wallet.transactions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;

public class WalletTransactionsParser extends AbstractApiParser<WalletTransactionsResponse> {
	protected static final String TRANSACTIONS_URL = "/WalletTransactions.xml.aspx";

	public WalletTransactionsParser() {
		super(WalletTransactionsResponse.class, 2, TRANSACTIONS_URL);
	}

	public WalletTransactionsResponse getTransactions(ApiAuth auth, Long beforeTransID) throws IOException, SAXException {
		Map<String, String> extraParams = new HashMap<String, String>();
		if (beforeTransID!=null) {
			extraParams.put("beforeTransID", beforeTransID.toString());
		}
		if(extraParams.size() > 0) {
			return getResponse(auth, Path.CHARACTER, extraParams);	
		}
		return getResponse(auth, Path.CHARACTER);
	}

	public WalletTransactionsResponse getTransactions(ApiAuth auth, int accountKey, Long beforeTransID) throws IOException, SAXException {
			Map<String, String> extraParams = new HashMap<String, String>();
			extraParams.put("accountKey", Integer.toString(accountKey));
			if (beforeTransID!=null) {
				extraParams.put("beforeTransID", beforeTransID.toString());
			}
			return getResponse(auth, Path.CORP, extraParams);	
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", ApiWalletTransaction.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addWalletTransaction");
		return digester;
	}

	public static WalletTransactionsParser getInstance() {
		return new WalletTransactionsParser();
	}
}