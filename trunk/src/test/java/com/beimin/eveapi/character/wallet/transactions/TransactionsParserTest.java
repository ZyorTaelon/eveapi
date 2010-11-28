package com.beimin.eveapi.character.wallet.transactions;

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
				.getResourceAsStream("/character/WalletTransactions.xml");
		WalletTransactionsResponse response = parser.getResponse(input);
		assertNotNull(response);
		Collection<ApiWalletTransaction> walletTransactions = response
				.getWalletTransactions();
		assertEquals(25, walletTransactions.size());
		boolean found = false;
		for (ApiWalletTransaction walletTransaction : walletTransactions) {
			if (walletTransaction.getTransactionID() == 1364611263) {
				found = true;
				Calendar calendar = Calendar.getInstance(TimeZone
						.getTimeZone("GMT"));
				calendar.set(Calendar.YEAR, 2010);
				calendar.set(Calendar.MONTH, 2);
				calendar.set(Calendar.DAY_OF_MONTH, 24);
				calendar.set(Calendar.HOUR_OF_DAY, 19);
				calendar.set(Calendar.MINUTE, 58);
				calendar.set(Calendar.SECOND, 00);
				calendar.set(Calendar.MILLISECOND, 00);
				assertEquals(calendar.getTime(),
						walletTransaction.getTransactionDate());
				assertEquals(1000, walletTransaction.getQuantity());
				assertEquals("Tungsten Charge M",
						walletTransaction.getTypeName());
				assertEquals(224, walletTransaction.getTypeID());
				assertEquals(25.11, walletTransaction.getPrice(), 0.00001);
				assertEquals(696416951L, walletTransaction.getClientID());
				assertEquals("OMG Junior", walletTransaction.getClientName());
				assertEquals(60012667, walletTransaction.getStationID());
				assertEquals("Osmon II - Moon 1 - Sisters of EVE Bureau",
						walletTransaction.getStationName());
				assertEquals("buy", walletTransaction.getTransactionType());
				assertEquals("personal", walletTransaction.getTransactionFor());
			}
		}
		assertTrue("test order wasn't found.", found);
	}
}