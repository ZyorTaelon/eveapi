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
		assertEquals(190, entries.size());
		boolean found = false;
		for (ApiJournalEntry journalEntry : entries) {
			if (journalEntry.getRefID() == 2531832751L) {
				found = true;
				Calendar calendar = Calendar.getInstance();
				calendar.set(Calendar.YEAR, 2010);
				calendar.set(Calendar.MONTH, 03);
				calendar.set(Calendar.DAY_OF_MONTH, 01);
				calendar.set(Calendar.HOUR_OF_DAY, 18);
				calendar.set(Calendar.MINUTE, 18);
				calendar.set(Calendar.SECOND, 0);
				calendar.set(Calendar.MILLISECOND, 0);
				assertEquals(calendar.getTime(), journalEntry.getDateTime());
				assertEquals(85, journalEntry.getRefTypeID());
				assertEquals(1000125, journalEntry.getOwnerID1());
				assertEquals("CONCORD", journalEntry.getOwnerName1());
				assertEquals(581630544, journalEntry.getOwnerID2());
				assertEquals("Perduim Oneraria", journalEntry.getOwnerName2());
				assertEquals(30000181L, journalEntry.getArgID1());
				assertEquals("Korsiki", journalEntry.getArgName1());
				assertEquals(660565.00, journalEntry.getAmount());
				assertEquals(37637165.84, journalEntry.getBalance());
				assertEquals("17035:1,17039:1,17042:2,17110:2,23996:5,23997:2,24024:2,", journalEntry.getReason());
			}
		}
		assertTrue("test journal entry wasn't found.", found);
	}
}