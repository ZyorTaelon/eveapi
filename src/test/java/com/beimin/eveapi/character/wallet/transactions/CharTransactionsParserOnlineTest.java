package com.beimin.eveapi.character.wallet.transactions;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.pilot.CharWalletTransactionsParser;
import com.beimin.eveapi.response.shared.WalletTransactionsResponse;

public class CharTransactionsParserOnlineTest extends AbstractOnlineTest {
    private CharWalletTransactionsParser classToTest = new CharWalletTransactionsParser();

    @Before
    public void prepare() {
        super.before();
        prepareParser(classToTest);
    }

    @Test @Ignore("No data returned by the API")
    public void getResponse() throws Exception {
        final WalletTransactionsResponse response = classToTest.getResponse(getCharacter());

        testResponse(response);
    }

    @Test @Ignore("No data returned by the API")
    public void getResponseKey() throws Exception {
        final WalletTransactionsResponse response = classToTest.getResponse(getCharacter(), 1000);

        testResponse(response);
    }

    @Test @Ignore("No data returned by the API")
    public void getResponseWalking() throws Exception {
        testFail("Transactions walking not tested");
        final WalletTransactionsResponse response = classToTest.getResponse(getCharacter(), 0, 0, 0);

        testResponse(response);
    }

}
