package com.beimin.eveapi.character.wallet.transactions;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.pilot.WalletTransactionsParser;
import com.beimin.eveapi.parser.shared.AbstractWalletTransactionsParser;
import com.beimin.eveapi.response.shared.WalletTransactionsResponse;

public class CharTransactionsParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        final AbstractWalletTransactionsParser parser = new WalletTransactionsParser();
        final WalletTransactionsResponse response = parser.getResponse(getPilot());
        testResponse(response);
    }

    @Test
    public void getResponseKey() throws Exception {
        final AbstractWalletTransactionsParser parser = new WalletTransactionsParser();
        final WalletTransactionsResponse response = parser.getResponse(getPilot(), 1000);
        testResponse(response);
    }

    @Test
    public void getResponseWalking() throws Exception {
        testFail("Transactions walking not tested");
        final AbstractWalletTransactionsParser parser = new WalletTransactionsParser();
        final WalletTransactionsResponse response = parser.getResponse(getPilot(), 0, 0, 0);
        testResponse(response);
    }

}
