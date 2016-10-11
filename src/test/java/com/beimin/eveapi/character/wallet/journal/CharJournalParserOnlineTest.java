package com.beimin.eveapi.character.wallet.journal;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.pilot.CharWalletJournalParser;
import com.beimin.eveapi.response.shared.WalletJournalResponse;

public class CharJournalParserOnlineTest extends AbstractOnlineTest {
    private CharWalletJournalParser classToTest = new CharWalletJournalParser();

    @Before
    public void prepare() {
        super.before();
        prepareParser(classToTest);
    }

    @Test @Ignore("No data returned by the API")
    public void getResponse() throws Exception {
        final WalletJournalResponse response = classToTest.getResponse(getCharacter());

        testResponse(response);
    }

    @Test @Ignore("No data returned by the API")
    public void getResponseKey() throws Exception {
        final WalletJournalResponse response = classToTest.getResponse(getCharacter(), 1000);

        testResponse(response);
    }

    @Test @Ignore("No data returned by the API")
    public void getResponseWalking() throws Exception {
        testFail("Journal walking not tested");
        final WalletJournalResponse response = classToTest.getResponse(getCharacter(), 0, 0L, 0);

        testResponse(response);
    }

}
