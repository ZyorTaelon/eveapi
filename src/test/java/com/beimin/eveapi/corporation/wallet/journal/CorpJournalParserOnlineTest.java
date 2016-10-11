package com.beimin.eveapi.corporation.wallet.journal;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.corporation.CorpWalletJournalParser;
import com.beimin.eveapi.response.shared.WalletJournalResponse;

public class CorpJournalParserOnlineTest extends AbstractOnlineTest {
    private CorpWalletJournalParser classToTest = new CorpWalletJournalParser();

    @Before
    public void prepare() {
        before();
        prepareParser(classToTest);
    }

    @Test @Ignore("No data returned by the API")
    public void getResponse() throws Exception {
        final WalletJournalResponse response = classToTest.getResponse(getCorp());
        testResponse(response);
    }

    @Test @Ignore("No data returned by the API")
    public void getResponseKey() throws Exception {
        final WalletJournalResponse response = classToTest.getResponse(getCorp(), 1000);
        testResponse(response);
    }

    @Test @Ignore("No data returned by the API")
    public void getResponseWalking() throws Exception {
        testFail("Journal walking not tested");
        final WalletJournalResponse response = classToTest.getResponse(getCorp(), 0, 0L, 0);
        testResponse(response);
    }

}
