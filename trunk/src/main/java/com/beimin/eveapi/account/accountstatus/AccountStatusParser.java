package com.beimin.eveapi.account.accountstatus;

import org.apache.commons.digester.Digester;

import com.beimin.eveapi.core.AbstractApiParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

public class AccountStatusParser extends AbstractApiParser<AccountStatusResponse> {
	public AccountStatusParser() {
		super(AccountStatusResponse.class, 2, ApiPath.ACCOUNT, ApiPage.ACCOUNT_STATUS);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result", EveAccountStatus.class);
		digester.addBeanPropertySetter("eveapi/result/userID");
		digester.addBeanPropertySetter("eveapi/result/paidUntil");
		digester.addBeanPropertySetter("eveapi/result/createDate");
		digester.addBeanPropertySetter("eveapi/result/logonCount");
		digester.addBeanPropertySetter("eveapi/result/logonMinutes");
		digester.addSetNext("eveapi/result", "set");
		return digester;
	}

	public static AccountStatusParser getInstance() {
		return new AccountStatusParser();
	}

	@Override
	public AccountStatusResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}