package com.beimin.eveapi.account.accountstatus;

import static com.beimin.eveapi.utils.Assert.assertDate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.beimin.eveapi.FullApiParserTest;

public class AccountStatusParserTest extends FullApiParserTest {
	public AccountStatusParserTest() {
		super("/account/AccountStatus.xml.aspx", "/account/AccountStatus.xml");
	}

	@Test
	public void testMockAPI() throws Exception {
		AccountStatusParser accountStatusParser = AccountStatusParser.getInstance();
		AccountStatusResponse response = accountStatusParser.getAccountStatus(auth);
		assertNotNull(response);
		assertEquals(541354, response.getUserID());
		assertDate(2011, 03, 13, 18, 40, 0, response.getPaidUntil());
		assertDate(2004, 07, 22, 23, 54, 0, response.getCreateDate());
		assertEquals(5603, response.getLogonCount());
		assertEquals(504903, response.getLogonMinutes());
	}
}