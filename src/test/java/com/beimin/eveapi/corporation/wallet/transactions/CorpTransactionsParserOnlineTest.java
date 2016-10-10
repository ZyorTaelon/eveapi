package com.beimin.eveapi.corporation.wallet.transactions;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.corporation.CorpWalletTransactionsParser;
import com.beimin.eveapi.response.shared.WalletTransactionsResponse;
import org.junit.Ignore;

public class CorpTransactionsParserOnlineTest extends AbstractOnlineTest {

    @Test @Ignore("No data returned by the API")
    public void getResponse() throws Exception {
        final CorpWalletTransactionsParser parser = new CorpWalletTransactionsParser();
        final WalletTransactionsResponse response = parser.getResponse(getCorp());
        testResponse(response);
    }

    @Test @Ignore("No data returned by the API")
    public void getResponseKey() throws Exception {
        final CorpWalletTransactionsParser parser = new CorpWalletTransactionsParser();
        final WalletTransactionsResponse response = parser.getResponse(getCorp(), 1000);
        testResponse(response);
    }

    @Test @Ignore("No data returned by the API")
    public void getResponseWalking() throws Exception {
        testFail("Transactions walking not tested");
        final CorpWalletTransactionsParser parser = new CorpWalletTransactionsParser();
        final WalletTransactionsResponse response = parser.getResponse(getCorp(), 0, 0, 0);
        testResponse(response);
    }

}
