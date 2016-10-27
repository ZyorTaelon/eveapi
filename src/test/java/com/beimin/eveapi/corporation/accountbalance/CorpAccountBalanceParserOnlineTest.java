package com.beimin.eveapi.corporation.accountbalance;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.corporation.CorpAccountBalanceParser;
import com.beimin.eveapi.response.shared.AccountBalanceResponse;

public class CorpAccountBalanceParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        setAlias(AccountBalanceResponse.class, "accounts", "items");
        final CorpAccountBalanceParser parser = new CorpAccountBalanceParser();
        prepareParser(parser);

        final AccountBalanceResponse response = parser.getResponse(getCorp());

        testResponse(response);
    }

}
