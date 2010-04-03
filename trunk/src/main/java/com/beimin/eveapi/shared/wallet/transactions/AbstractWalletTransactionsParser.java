package com.beimin.eveapi.shared.wallet.transactions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;

public abstract class AbstractWalletTransactionsParser extends AbstractApiParser<WalletTransactionsResponse> {
	protected static final String TRANSACTIONS_URL = "/WalletTransactions.xml.aspx";
	private final Path path;

	public AbstractWalletTransactionsParser(Path path) {
		super(WalletTransactionsResponse.class, 2, TRANSACTIONS_URL);
		this.path = path;
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", ApiWalletTransaction.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addWalletTransaction");
		return digester;
	}

	public WalletTransactionsResponse getTransactionsResponse(ApiAuth auth, int accountKey) throws IOException, SAXException {
		Map<String, String> extraParams = new HashMap<String, String>();
		extraParams.put("accountKey", Integer.toString(accountKey));
		return getResponse(auth, path, extraParams);	
	}

	public WalletTransactionsResponse getTransactionsResponse(ApiAuth auth, int accountKey, long beforeTransID) throws IOException, SAXException {
			Map<String, String> extraParams = new HashMap<String, String>();
			extraParams.put("accountKey", Integer.toString(accountKey));
			extraParams.put("beforeTransID", Long.toString(beforeTransID));
			return getResponse(auth, path, extraParams);	
	}
}