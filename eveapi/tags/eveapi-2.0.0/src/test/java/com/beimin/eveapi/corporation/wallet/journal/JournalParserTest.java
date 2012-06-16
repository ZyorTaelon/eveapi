package com.beimin.eveapi.corporation.wallet.journal;

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
		InputStream input = JournalParserTest.class.getResourceAsStream("/corporation/WalletJournal.xml");
		WalletJournalResponse response = parser.getResponse(input);
		assertNotNull(response);
		Collection<ApiJournalEntry> entries = response.getJournalEntries();
		assertEquals(5, entries.size());
		boolean found = false;
		for (ApiJournalEntry journalEntry : entries) {
			if (journalEntry.getRefID() == 59149) {
				found = true;
				Calendar calendar = Calendar.getInstance();
				calendar.set(Calendar.YEAR, 2007);
				calendar.set(Calendar.MONTH, 05);
				calendar.set(Calendar.DAY_OF_MONTH, 15);
				calendar.set(Calendar.HOUR_OF_DAY, 14);
				calendar.set(Calendar.MINUTE, 13);
				calendar.set(Calendar.SECOND, 0);
				calendar.set(Calendar.MILLISECOND, 0);
				assertEquals(calendar.getTime(), journalEntry.getDateTime());
				assertEquals(54, journalEntry.getRefTypeID());
				assertEquals(150337897, journalEntry.getOwnerID1());
				assertEquals("Secure Commerce Commission", journalEntry.getOwnerName2());
				assertEquals(1000132, journalEntry.getOwnerID2());
				assertEquals("", journalEntry.getArgName1());
				assertEquals(0, journalEntry.getArgID1());
				assertEquals(-7.93, journalEntry.getAmount());
				assertEquals(190210393.87, journalEntry.getBalance());
				assertEquals("", journalEntry.getReason());
			}
		}
		assertTrue("test journal entry wasn't found.", found);
	}
}