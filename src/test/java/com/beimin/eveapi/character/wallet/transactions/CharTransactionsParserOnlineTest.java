package com.beimin.eveapi.character.wallet.transactions;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.pilot.CharWalletTransactionsParser;
import com.beimin.eveapi.response.shared.WalletTransactionsResponse;
import org.junit.Ignore;

public class CharTransactionsParserOnlineTest extends AbstractOnlineTest {

    @Test @Ignore("No data returned by the API")
    public void getResponse() throws Exception {
        final CharWalletTransactionsParser parser = new CharWalletTransactionsParser();
        final WalletTransactionsResponse response = parser.getResponse(getPilot());
        testResponse(response);
    }

    @Test @Ignore("No data returned by the API")
    public void getResponseKey() throws Exception {
        final CharWalletTransactionsParser parser = new CharWalletTransactionsParser();
        final WalletTransactionsResponse response = parser.getResponse(getPilot(), 1000);
        testResponse(response);
    }

    @Test @Ignore("No data returned by the API")
    public void getResponseWalking() throws Exception {
        testFail("Transactions walking not tested");
        final CharWalletTransactionsParser parser = new CharWalletTransactionsParser();
        final WalletTransactionsResponse response = parser.getResponse(getPilot(), 0, 0, 0);
        testResponse(response);
    }

}
