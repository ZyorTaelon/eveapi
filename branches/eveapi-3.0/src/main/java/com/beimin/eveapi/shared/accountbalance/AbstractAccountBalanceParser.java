package com.beimin.eveapi.shared.accountbalance;

import org.apache.commons.digester.Digester;

import com.beimin.eveapi.core.AbstractApiParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

public abstract class AbstractAccountBalanceParser extends AbstractApiParser<AccountBalanceResponse> {
	protected AbstractAccountBalanceParser(ApiPath path) {
		super(AccountBalanceResponse.class, 2, path, ApiPage.ACCOUNT_BALANCE);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", ApiAccountBalance.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addAccountBalance");
		return digester;
	}

	@Override
	public AccountBalanceResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}