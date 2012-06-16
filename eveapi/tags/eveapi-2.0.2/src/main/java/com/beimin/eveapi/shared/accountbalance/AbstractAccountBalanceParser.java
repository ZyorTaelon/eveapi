package com.beimin.eveapi.shared.accountbalance;

import java.io.IOException;
import java.util.Collection;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;

public abstract class AbstractAccountBalanceParser extends AbstractApiParser<AccountBalanceResponse> {
	protected static final String ACCOUNTBALANCE_URL = "/AccountBalance.xml.aspx";
	private final Path path;

	protected AbstractAccountBalanceParser(Path path) {
		super(AccountBalanceResponse.class, 2, ACCOUNTBALANCE_URL);
		this.path = path;
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", ApiAccountBalance.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addAccountBalance");
		return digester;
	}

	public AccountBalanceResponse getAccountBalanceResponse(ApiAuth auth) throws IOException, SAXException {
		return getResponse(auth, path);
	}
	
	public Collection<ApiAccountBalance> getAccountBalances(ApiAuth auth) throws IOException, SAXException {
		return getAccountBalanceResponse(auth).getAccountBalances();
	}
}