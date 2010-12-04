package com.beimin.eveapi.corporation.accountbalance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Collection;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.beimin.eveapi.ApiPage;
import com.beimin.eveapi.ApiPath;
import com.beimin.eveapi.shared.accountbalance.AccountBalanceResponse;
import com.beimin.eveapi.shared.accountbalance.ApiAccountBalance;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class AccountBalanceParserTest extends FullAuthParserTest {
	public AccountBalanceParserTest() {
		super(ApiPath.CORPORATION, ApiPage.ACCOUNT_BALANCE);
	}

	@Test
	public void accountBalanceParser() throws IOException, SAXException {
		AccountBalanceParser parser = AccountBalanceParser.getInstance();
		AccountBalanceResponse response = parser.getResponse(auth);
		assertNotNull(response);
		Collection<ApiAccountBalance> accountBalances = response.getAccountBalances();
		assertNotNull(accountBalances);
		assertEquals(7, accountBalances.size());
		boolean found = false;
		for (ApiAccountBalance accountBalance : accountBalances) {
			if (accountBalance.getAccountID() == 5689) {
				found = true;
				assertEquals(1003, accountBalance.getAccountKey());
				assertEquals(17349111.00, accountBalance.getBalance(), 0.00001);
			}
		}
		assertTrue("test accountBalance wasn't found.", found);
	}
}