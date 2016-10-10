package com.beimin.eveapi.account.accountstatus;

import org.junit.Ignore;
import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.account.AccountStatusParser;
import com.beimin.eveapi.response.account.AccountStatusResponse;

public class AccountStatusParserOnlineTest extends AbstractOnlineTest {

    @Test @Ignore("userID no longer returned by the API")
    public void getResponse() throws Exception {
        final AccountStatusParser accountStatusParser = new AccountStatusParser();
        prepareParser(accountStatusParser);

        final AccountStatusResponse response = accountStatusParser.getResponse(getAccount());

        testResponse(response);
    }

}
