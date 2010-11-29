package com.beimin.eveapi.character.wallet.transactions;

import static com.beimin.eveapi.utils.Assert.assertDate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.beimin.eveapi.shared.wallet.transactions.AbstractWalletTransactionsParser;
import com.beimin.eveapi.shared.wallet.transactions.ApiWalletTransaction;
import com.beimin.eveapi.shared.wallet.transactions.WalletTransactionsResponse;

public class TransactionsParserTest {

	@Test
	public void walletTransactionParser() throws IOException, SAXException {
		AbstractWalletTransactionsParser parser = WalletTransactionsParser.getInstance();
		InputStream input = TransactionsParserTest.class.getResourceAsStream("/character/WalletTransactions.xml");
		WalletTransactionsResponse response = parser.getResponse(input);
		assertNotNull(response);
		Collection<ApiWalletTransaction> walletTransactions = response.getWalletTransactions();
		assertEquals(25, walletTransactions.size());
		boolean found = false;
		for (ApiWalletTransaction walletTransaction : walletTransactions) {
			if (walletTransaction.getTransactionID() == 1364611263) {
				found = true;
				assertDate(2010, 3, 24, 19, 58, 0, walletTransaction.getTransactionDateTime());
				assertEquals(1000, walletTransaction.getQuantity());
				assertEquals("Tungsten Charge M", walletTransaction.getTypeName());
				assertEquals(224, walletTransaction.getTypeID());
				assertEquals(25.11, walletTransaction.getPrice(), 0.00001);
				assertEquals(696416951L, walletTransaction.getClientID());
				assertEquals("OMG Junior", walletTransaction.getClientName());
				assertEquals(60012667, walletTransaction.getStationID());
				assertEquals("Osmon II - Moon 1 - Sisters of EVE Bureau", walletTransaction.getStationName());
				assertEquals("buy", walletTransaction.getTransactionType());
				assertEquals("personal", walletTransaction.getTransactionFor());
			}
		}
		assertTrue("test order wasn't found.", found);
	}
}