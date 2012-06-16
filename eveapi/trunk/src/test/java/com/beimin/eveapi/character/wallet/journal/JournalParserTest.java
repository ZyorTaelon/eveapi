package com.beimin.eveapi.character.wallet.journal;

import static com.beimin.eveapi.utils.Assert.assertDate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.Map;

import org.junit.Test;

import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.shared.wallet.RefType;
import com.beimin.eveapi.shared.wallet.journal.AbstractWalletJournalParser;
import com.beimin.eveapi.shared.wallet.journal.ApiJournalEntry;
import com.beimin.eveapi.shared.wallet.journal.WalletJournalResponse;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class JournalParserTest extends FullAuthParserTest {
	public JournalParserTest() {
		super(ApiPath.CHARACTER, ApiPage.WALLET_JOURNAL);
	}

	@Test
	public void getResponse() throws ApiException {
		AbstractWalletJournalParser parser = WalletJournalParser.getInstance();
		WalletJournalResponse response = parser.getResponse(auth, 1000);
		assertNotNull(response);
		Collection<ApiJournalEntry> entries = response.getAll();
		assertEquals(10, entries.size());
		boolean found = false;
		for (ApiJournalEntry journalEntry : entries) {
			if (journalEntry.getRefID() == 1575178032L) {
				found = true;
				assertDate(2008, 8, 20, 13, 10, 0, journalEntry.getDate());
				assertEquals(RefType.BOUNTY_PRIZES, journalEntry.getRefType());
				assertEquals(1000125, journalEntry.getOwnerID1());
				assertEquals("CONCORD", journalEntry.getOwnerName1());
				assertEquals(173993711, journalEntry.getOwnerID2());
				assertEquals("anonymous", journalEntry.getOwnerName2());
				assertEquals(30001660L, journalEntry.getArgID1());
				assertEquals("Jita", journalEntry.getArgName1());
				assertEquals(135000.00, journalEntry.getAmount(), 0.00001);
				assertEquals(609292267.52, journalEntry.getBalance(), 0.00001);
				assertEquals("29200:15,", journalEntry.getReason());
				assertEquals(1734917694L, journalEntry.getTaxReceiverID().longValue());
				assertEquals(15000.00, journalEntry.getTaxAmount(), 0.00001);
			}
		}
		assertTrue("test journal entry wasn't found.", found);
	}

	@Override
	public void extraAsserts(Map<String, String> req) {
		super.extraAsserts(req);
		assertEquals("1000", req.get("accountKey"));
	}
}