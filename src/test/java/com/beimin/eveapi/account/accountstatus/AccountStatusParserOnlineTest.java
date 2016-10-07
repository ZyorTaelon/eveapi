package com.beimin.eveapi.account.accountstatus;


import com.beimin.eveapi.AbstractOnlineTest;
import org.junit.Test;

import com.beimin.eveapi.parser.account.AccountStatusParser;
import com.beimin.eveapi.response.account.AccountStatusResponse;

public class AccountStatusParserOnlineTest extends AbstractOnlineTest {

	@Test
	public void getResponse() throws Exception {
		AccountStatusParser accountStatusParser = new AccountStatusParser();
		AccountStatusResponse response = accountStatusParser.getResponse(getAccount());
		testResponse(response);
	}

}