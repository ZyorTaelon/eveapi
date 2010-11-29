package com.beimin.eveapi.account.accountstatus;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;

public class AccountStatusParser extends AbstractApiParser<AccountStatusResponse> {
	protected static final String ACCOUNT_STATUS_URL = "/AccountStatus";

	public AccountStatusParser() {
		super(AccountStatusResponse.class, 2, ACCOUNT_STATUS_URL);
	}

	public AccountStatusResponse getEveCharacters(ApiAuth auth) throws IOException, SAXException {
		return getResponse(auth, Path.ACCOUNT);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addBeanPropertySetter("eveapi/result/userID");
		digester.addBeanPropertySetter("eveapi/result/paidUntil");
		digester.addBeanPropertySetter("eveapi/result/createDate");
		digester.addBeanPropertySetter("eveapi/result/logonCount");
		digester.addBeanPropertySetter("eveapi/result/logonMinutes");
		return digester;
	}

	public static AccountStatusParser getInstance() {
		return new AccountStatusParser();
	}
}