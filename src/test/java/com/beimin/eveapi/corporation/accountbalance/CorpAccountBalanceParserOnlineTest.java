package com.beimin.eveapi.corporation.accountbalance;


import com.beimin.eveapi.AbstractOnlineTest;

import org.junit.Test;

import com.beimin.eveapi.parser.corporation.AccountBalanceParser;
import com.beimin.eveapi.response.shared.AccountBalanceResponse;

public class CorpAccountBalanceParserOnlineTest extends AbstractOnlineTest {

	@Test
	public void getResponse() throws Exception {
		AccountBalanceParser parser = new AccountBalanceParser();
		AccountBalanceResponse response = parser.getResponse(getCorp());
		testResponse(response);
	}

}