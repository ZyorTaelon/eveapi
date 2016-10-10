package com.beimin.eveapi.corporation.wallet.journal;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.corporation.CorpWalletJournalParser;
import com.beimin.eveapi.response.shared.WalletJournalResponse;
import org.junit.Ignore;

public class CorpJournalParserOnlineTest extends AbstractOnlineTest {

    @Test @Ignore("No data returned by the API")
    public void getResponse() throws Exception {
        final CorpWalletJournalParser parser = new CorpWalletJournalParser();
        final WalletJournalResponse response = parser.getResponse(getCorp());
        testResponse(response);
    }

    @Test @Ignore("No data returned by the API")
    public void getResponseKey() throws Exception {
        final CorpWalletJournalParser parser = new CorpWalletJournalParser();
        final WalletJournalResponse response = parser.getResponse(getCorp(), 1000);
        testResponse(response);
    }

    @Test @Ignore("No data returned by the API")
    public void getResponseWalking() throws Exception {
        testFail("Journal walking not tested");
        final CorpWalletJournalParser parser = new CorpWalletJournalParser();
        final WalletJournalResponse response = parser.getResponse(getCorp(), 0, 0L, 0);
        testResponse(response);
    }

}
