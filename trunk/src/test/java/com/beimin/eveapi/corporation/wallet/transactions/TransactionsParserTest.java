package com.beimin.eveapi.corporation.wallet.transactions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Collection;
import java.util.TimeZone;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.beimin.eveapi.shared.wallet.transactions.AbstractWalletTransactionsParser;
import com.beimin.eveapi.shared.wallet.transactions.ApiWalletTransaction;
import com.beimin.eveapi.shared.wallet.transactions.WalletTransactionsResponse;

public class TransactionsParserTest {

	@Test
	public void walletTransactionParser() throws IOException, SAXException,
			ParseException {
		AbstractWalletTransactionsParser parser = WalletTransactionsParser
				.getInstance();
		InputStream input = TransactionsParserTest.class
				.getResourceAsStream("/corporation/WalletTransactions.xml");
		WalletTransactionsResponse response = parser.getResponse(input);
		assertNotNull(response);
		Collection<ApiWalletTransaction> walletTransactions = response
				.getWalletTransactions();
		assertEquals(4, walletTransactions.size());
		boolean found = false;
		for (ApiWalletTransaction walletTransaction : walletTransactions) {
			if (walletTransaction.getTransactionID() == 705664738) {
				found = true;
				Calendar calendar = Calendar.getInstance(TimeZone
						.getTimeZone("GMT"));
				calendar.set(Calendar.YEAR, 2008);
				calendar.set(Calendar.MONTH, 7);
				calendar.set(Calendar.DAY_OF_MONTH, 4);
				calendar.set(Calendar.HOUR_OF_DAY, 22);
				calendar.set(Calendar.MINUTE, 01);
				calendar.set(Calendar.SECOND, 0);
				calendar.set(Calendar.MILLISECOND, 0);
				assertEquals(calendar.getTime(),
						walletTransaction.getTransactionDate());

				assertEquals(50000, walletTransaction.getQuantity());
				assertEquals("Oxygen Isotopes", walletTransaction.getTypeName());
				assertEquals(17887, walletTransaction.getTypeID());
				assertEquals(250.01, walletTransaction.getPrice(), 0.00001);
				assertEquals(174312871, walletTransaction.getClientID());
				assertEquals("ACHAR", walletTransaction.getClientName());
				assertEquals(000000000, walletTransaction.getCharacterID());
				assertEquals("SELLER", walletTransaction.getCharacterName());
				assertEquals(60004375, walletTransaction.getStationID());
				assertEquals(
						"SYSTEM IV - Moon 10 - Corporate Police Force Testing Facilities",
						walletTransaction.getStationName());
				assertEquals("buy", walletTransaction.getTransactionType());
				assertEquals("corporation",
						walletTransaction.getTransactionFor());
			}
		}
		assertTrue("test order wasn't found.", found);
	}
}