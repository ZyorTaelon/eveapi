package com.beimin.eveapi.balance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.Collection;

import org.junit.Test;
import org.xml.sax.SAXException;


public class ParserTest {

	@Test
	public void testAccountBalanceParser() throws IOException, SAXException, ParseException {
		Parser parser = Parser.getInstance();
		InputStream input = ParserTest.class.getResourceAsStream("/AccountBalance.xml");
		Response response = parser.getResponse(input);
		assertNotNull(response);
		Collection<ApiAccountBalance> accountBalances = response.getAccountBalances();
		assertNotNull(accountBalances);
		assertEquals(7, accountBalances.size());
		boolean found = false;
		for (ApiAccountBalance accountBalance : accountBalances) {
			if (accountBalance.getAccountID() == 5689) {
				found = true;
				assertEquals(1003, accountBalance.getAccountKey());
				assertEquals(17349111.00, accountBalance.getBalance());
			}
		}
		assertTrue("test accountBalance wasn't found.", found);
	}
}