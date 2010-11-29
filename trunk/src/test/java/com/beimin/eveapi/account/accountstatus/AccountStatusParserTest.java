package com.beimin.eveapi.account.accountstatus;

import static com.beimin.eveapi.utils.Assert.assertDate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;
import org.xml.sax.SAXException;

public class AccountStatusParserTest {

	@Test
	public void testCharacterListParser() throws IOException, SAXException {
		AccountStatusParser parser = AccountStatusParser.getInstance();
		InputStream input = AccountStatusParserTest.class.getResourceAsStream("/account/AccountStatus.xml");
		AccountStatusResponse response = parser.getResponse(input);
		assertNotNull(response);
		assertEquals(541354, response.getUserID());
		assertDate(2011, 03, 13, 18, 40, 0, response.getPaidUntil());
		assertDate(2004, 07, 22, 23, 54, 0, response.getCreateDate());
		assertEquals(5603, response.getLogonCount());
		assertEquals(504903, response.getLogonMinutes());
	}
}