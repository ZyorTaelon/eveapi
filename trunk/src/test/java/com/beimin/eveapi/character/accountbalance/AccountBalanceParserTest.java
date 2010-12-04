package com.beimin.eveapi.character.accountbalance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
		super(ApiPath.CHARACTER, ApiPage.ACCOUNT_BALANCE);
	}

	@Test
	public void getResponse() throws IOException, SAXException {
		AccountBalanceParser parser = AccountBalanceParser.getInstance();
		AccountBalanceResponse response = parser.getResponse(auth);
		assertNotNull(response);
		Collection<ApiAccountBalance> accountBalances = response.getAccountBalances();
		assertNotNull(accountBalances);
		assertEquals(1, accountBalances.size());
		ApiAccountBalance accountBalance = accountBalances.iterator().next();
		assertEquals(10094361, accountBalance.getAccountID());
		assertEquals(1000, accountBalance.getAccountKey());
		assertEquals(46634844.84, accountBalance.getBalance(), 0.00001);
	}
}