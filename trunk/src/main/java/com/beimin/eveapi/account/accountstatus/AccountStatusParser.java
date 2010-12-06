package com.beimin.eveapi.account.accountstatus;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;
import com.beimin.eveapi.ApiPage;
import com.beimin.eveapi.ApiPath;

public class AccountStatusParser extends AbstractApiParser<AccountStatusResponse> {
	public AccountStatusParser() {
		super(AccountStatusResponse.class, 2, ApiPath.ACCOUNT, ApiPage.ACCOUNT_STATUS);
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

	@Override
	public AccountStatusResponse getResponse(ApiAuth auth) throws IOException, SAXException {
		return super.getResponse(auth);
	}
}