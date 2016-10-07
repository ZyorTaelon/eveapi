package com.beimin.eveapi.corporation.wallet.journal;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.corporation.WalletJournalParser;
import com.beimin.eveapi.parser.shared.AbstractWalletJournalParser;
import com.beimin.eveapi.response.shared.WalletJournalResponse;

public class CorpJournalParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        final AbstractWalletJournalParser parser = new WalletJournalParser();
        final WalletJournalResponse response = parser.getResponse(getCorp());
        testResponse(response);
    }

    @Test
    public void getResponseKey() throws Exception {
        final AbstractWalletJournalParser parser = new WalletJournalParser();
        final WalletJournalResponse response = parser.getResponse(getCorp(), 1000);
        testResponse(response);
    }

    @Test
    public void getResponseWalking() throws Exception {
        testFail("Journal walking not tested");
        final AbstractWalletJournalParser parser = new WalletJournalParser();
        final WalletJournalResponse response = parser.getResponse(getCorp(), 0, 0L, 0);
        testResponse(response);
    }

}