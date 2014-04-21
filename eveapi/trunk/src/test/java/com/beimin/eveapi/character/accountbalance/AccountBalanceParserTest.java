package com.beimin.eveapi.character.accountbalance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Set;

import org.junit.Test;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.model.shared.EveAccountBalance;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.pilot.PilotAccountBalanceParser;
import com.beimin.eveapi.response.shared.AccountBalanceResponse;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class AccountBalanceParserTest extends FullAuthParserTest {
	public AccountBalanceParserTest() {
		super(ApiPath.CHARACTER, ApiPage.ACCOUNT_BALANCE);
	}

	@Test
	public void getResponse() throws ApiException {
		PilotAccountBalanceParser parser = new PilotAccountBalanceParser();
		AccountBalanceResponse response = parser.getResponse(auth);
		assertNotNull(response);
		Set<EveAccountBalance> accountBalances = response.getAll();
		assertNotNull(accountBalances);
		assertEquals(1, accountBalances.size());
		EveAccountBalance accountBalance = accountBalances.iterator().next();
		assertEquals(10094361, accountBalance.getAccountID());
		assertEquals(1000, accountBalance.getAccountKey());
		assertEquals(46634844.84, accountBalance.getBalance(), 0.00001);
	}
}