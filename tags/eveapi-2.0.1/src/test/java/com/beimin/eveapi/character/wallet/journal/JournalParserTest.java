package com.beimin.eveapi.character.wallet.journal;

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

import com.beimin.eveapi.shared.wallet.journal.AbstractWalletJournalParser;
import com.beimin.eveapi.shared.wallet.journal.ApiJournalEntry;
import com.beimin.eveapi.shared.wallet.journal.WalletJournalResponse;

public class JournalParserTest {

	@Test
	public void walletJournalParser() throws IOException, SAXException, ParseException {
		AbstractWalletJournalParser parser = WalletJournalParser.getInstance();
		InputStream input = JournalParserTest.class.getResourceAsStream("/character/WalletJournal.xml");
		WalletJournalResponse response = parser.getResponse(input);
		assertNotNull(response);
		Collection<ApiJournalEntry> entries = response.getJournalEntries();
		assertEquals(10, entries.size());
		boolean found = false;
		for (ApiJournalEntry journalEntry : entries) {
			if (journalEntry.getRefID() == 1575178032L) {
				found = true;
				Calendar calendar = Calendar.getInstance();
				calendar.set(Calendar.YEAR, 2008);
				calendar.set(Calendar.MONTH, 7);
				calendar.set(Calendar.DAY_OF_MONTH, 20);
				calendar.set(Calendar.HOUR_OF_DAY, 13);
				calendar.set(Calendar.MINUTE, 10);
				calendar.set(Calendar.SECOND, 0);
				calendar.set(Calendar.MILLISECOND, 0);
				assertEquals(calendar.getTime(), journalEntry.getDateTime());
				assertEquals(85, journalEntry.getRefTypeID());
				assertEquals(1000125, journalEntry.getOwnerID1());
				assertEquals("CONCORD", journalEntry.getOwnerName1());
				assertEquals(173993711, journalEntry.getOwnerID2());
				assertEquals("anonymous", journalEntry.getOwnerName2());
				assertEquals(30001660L, journalEntry.getArgID1());
				assertEquals("Jita", journalEntry.getArgName1());
				assertEquals(135000.00, journalEntry.getAmount());
				assertEquals(609292267.52, journalEntry.getBalance());
				assertEquals("29200:15,", journalEntry.getReason());
				assertEquals(1734917694L, journalEntry.getTaxReceiverID());
				assertEquals(15000.00, journalEntry.getTaxAmount());
			}
		}
		assertTrue("test journal entry wasn't found.", found);
	}
}