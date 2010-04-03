package com.beimin.eveapi.shared.accountbalance;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;

public class AccountBalanceParser extends AbstractApiParser<AccountBalanceResponse> {
	protected static final String ACCOUNTBALANCE_URL = "/AccountBalance.xml.aspx";

	public AccountBalanceParser() {
		super(AccountBalanceResponse.class, 1, ACCOUNTBALANCE_URL);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", ApiAccountBalance.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addAccountBalance");
		return digester;
	}

	public AccountBalanceResponse getAccountBalance(ApiAuth auth, boolean corporation) throws IOException, SAXException {
		if (corporation)
			return getResponse(auth, Path.CORP);
		return getResponse(auth, Path.CHARACTER);
	}

	public static AccountBalanceParser getInstance() {
		return new AccountBalanceParser();
	}
}