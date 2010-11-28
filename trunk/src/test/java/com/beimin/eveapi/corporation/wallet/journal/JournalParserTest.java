package com.beimin.eveapi.corporation.wallet.journal;

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

import com.beimin.eveapi.shared.wallet.journal.AbstractWalletJournalParser;
import com.beimin.eveapi.shared.wallet.journal.ApiJournalEntry;
import com.beimin.eveapi.shared.wallet.journal.WalletJournalResponse;

public class JournalParserTest {

	@Test
	public void walletJournalParser() throws IOException, SAXException,
			ParseException {
		AbstractWalletJournalParser parser = WalletJournalParser.getInstance();
		InputStream input = JournalParserTest.class
				.getResourceAsStream("/corporation/WalletJournal.xml");
		WalletJournalResponse response = parser.getResponse(input);
		assertNotNull(response);
		Collection<ApiJournalEntry> entries = response.getJournalEntries();
		assertEquals(5, entries.size());
		boolean found = false;
		for (ApiJournalEntry journalEntry : entries) {
			if (journalEntry.getRefID() == 2566012762L) {
				found = true;
				Calendar calendar = Calendar.getInstance(TimeZone
						.getTimeZone("GMT"));
				calendar.set(Calendar.YEAR, 2010);
				calendar.set(Calendar.MONTH, 3);
				calendar.set(Calendar.DAY_OF_MONTH, 9);
				calendar.set(Calendar.HOUR_OF_DAY, 15);
				calendar.set(Calendar.MINUTE, 53);
				calendar.set(Calendar.SECOND, 0);
				calendar.set(Calendar.MILLISECOND, 0);
				assertEquals(calendar.getTime(), journalEntry.getDateTime());
				assertEquals(42, journalEntry.getRefTypeID());
				assertEquals("corpslave", journalEntry.getOwnerName1());
				assertEquals(150337897, journalEntry.getOwnerID1());
				assertEquals("Secure Commerce Commission",
						journalEntry.getOwnerName2());
				assertEquals(1000132, journalEntry.getOwnerID2());
				assertEquals("", journalEntry.getArgName1());
				assertEquals(0, journalEntry.getArgID1());
				assertEquals(-589996.29, journalEntry.getAmount(), 0.00001);
				assertEquals(337405445.52, journalEntry.getBalance(), 0.00001);
				assertEquals("", journalEntry.getReason());
				assertEquals(0L, journalEntry.getTaxReceiverID());
				assertEquals(0.0, journalEntry.getTaxAmount(), 0.00001);
			}
		}
		assertTrue("test journal entry wasn't found.", found);
	}
}