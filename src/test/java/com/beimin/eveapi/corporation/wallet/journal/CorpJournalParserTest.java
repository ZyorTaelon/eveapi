package com.beimin.eveapi.corporation.wallet.journal;


import java.util.Collection;
import java.util.Map;

import org.junit.Test;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.model.shared.JournalEntry;
import com.beimin.eveapi.model.shared.RefType;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.corporation.CorpWalletJournalParser;
import com.beimin.eveapi.response.shared.WalletJournalResponse;
import com.beimin.eveapi.utils.FullAuthParserTest;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static com.beimin.eveapi.utils.Assert.assertDate;

public class CorpJournalParserTest extends FullAuthParserTest {
    public CorpJournalParserTest() {
        super(ApiPath.CORPORATION, ApiPage.WALLET_JOURNAL);
    }

    @Test
    public void getResponse() throws ApiException {
        final CorpWalletJournalParser parser = new CorpWalletJournalParser();
        final WalletJournalResponse response = parser.getResponse(auth, 1000);
        assertNotNull(response);
        final Collection<JournalEntry> entries = response.getAll();
        assertEquals(5, entries.size());
        boolean found = false;
        for (final JournalEntry journalEntry : entries) {
            if (journalEntry.getRefID() == 2566012762L) {
                found = true;
                assertDate(2010, 4, 9, 15, 53, 0, journalEntry.getDate());
                assertEquals(RefType.MARKET_ESCROW, journalEntry.getRefType());
                assertEquals("corpslave", journalEntry.getOwnerName1());
                assertEquals(150337897, journalEntry.getOwnerID1());
                assertEquals("Secure Commerce Commission", journalEntry.getOwnerName2());
                assertEquals(1000132, journalEntry.getOwnerID2());
                assertEquals("", journalEntry.getArgName1());
                assertEquals(0, journalEntry.getArgID1());
                assertEquals(-589996.29, journalEntry.getAmount(), 0.00001);
                assertEquals(337405445.52, journalEntry.getBalance(), 0.00001);
                assertEquals("", journalEntry.getReason());
                assertNull(journalEntry.getTaxReceiverID());
                assertNull(journalEntry.getTaxAmount());
                assertEquals(1384, journalEntry.getOwner1TypeID());
                assertEquals(2, journalEntry.getOwner2TypeID());
            }
        }
        assertTrue("test journal entry wasn't found.", found);
    }

    @Override
    public void extraAsserts(final Map<String, String> req) {
        super.extraAsserts(req);
        assertEquals("1000", req.get("accountKey"));
    }
}

