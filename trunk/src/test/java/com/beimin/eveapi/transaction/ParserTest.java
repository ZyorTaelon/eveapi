package com.beimin.eveapi.transaction;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Collection;

import org.junit.Test;
import org.xml.sax.SAXException;

public class ParserTest {

	@Test
	public void testWalletTransactionParser() throws IOException, SAXException, ParseException {
		Parser parser = Parser.getInstance();
		InputStream input = ParserTest.class.getResourceAsStream("/WalletTransactions.xml");
		Response response = parser.getResponse(input);
		assertNotNull(response);
		Collection<ApiWalletTransaction> walletTransactions = response.getWalletTransactions();
		assertEquals(4, walletTransactions.size());
		boolean found = false;
		for (ApiWalletTransaction walletTransaction : walletTransactions) {
			if (walletTransaction.getTransactionID() == 619) {
				found = true;
				Calendar calendar = Calendar.getInstance();
				calendar.set(Calendar.YEAR, 2007);
				calendar.set(Calendar.MONTH, 05);
				calendar.set(Calendar.DAY_OF_MONTH, 13);
				calendar.set(Calendar.HOUR_OF_DAY, 20);
				calendar.set(Calendar.MINUTE, 26);
				calendar.set(Calendar.SECOND, 0);
				calendar.set(Calendar.MILLISECOND, 0);
				assertEquals(calendar.getTime(), walletTransaction.getTransactionDate());

				assertEquals(10, walletTransaction.getQuantity());
				assertEquals("Strontium Clathrates", walletTransaction.getTypeName());
				assertEquals(16275, walletTransaction.getTypeID());
				assertEquals(999.00, walletTransaction.getPrice());
				assertEquals(150208955, walletTransaction.getClientID());
				assertEquals("Mark Roled", walletTransaction.getClientName());
				assertEquals(0, walletTransaction.getCharacterID());
				assertEquals("Mark Roled", walletTransaction.getCharacterName());
				assertEquals(60001870, walletTransaction.getStationID());
				assertEquals("Eglennaert I - Moon 11 - Nugoeihuvi Corporation Development Studio", walletTransaction.getStationName());
				assertEquals("buy", walletTransaction.getTransactionType());
			}
		}
		assertTrue("test order wasn't found.", found);
	}
}