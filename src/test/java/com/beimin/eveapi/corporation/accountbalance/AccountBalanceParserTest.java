package com.beimin.eveapi.corporation.accountbalance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Test;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.model.shared.EveAccountBalance;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.corporation.AccountBalanceParser;
import com.beimin.eveapi.response.shared.AccountBalanceResponse;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class AccountBalanceParserTest extends FullAuthParserTest {
	public AccountBalanceParserTest() {
		super(ApiPath.CORPORATION, ApiPage.ACCOUNT_BALANCE);
	}

	@Test
	public void accountBalanceParser() throws ApiException {
		AccountBalanceParser parser = new AccountBalanceParser();
		AccountBalanceResponse response = parser.getResponse(auth);
		assertNotNull(response);
		Set<EveAccountBalance> accountBalances = response.getAll();
		assertNotNull(accountBalances);
		assertEquals(7, accountBalances.size());
		boolean found = false;
		for (EveAccountBalance accountBalance : accountBalances) {
			if (accountBalance.getAccountID() == 5689) {
				found = true;
				assertEquals(1003, accountBalance.getAccountKey());
				assertEquals(17349111.00, accountBalance.getBalance(), 0.00001);
			}
		}
		assertTrue("test accountBalance wasn't found.", found);
	}
}