package com.beimin.eveapi.account.accountstatus;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.TestControl;
import com.beimin.eveapi.parser.account.AccountStatusParser;
import com.beimin.eveapi.response.account.AccountStatusResponse;
import static org.junit.Assume.assumeTrue;

public class AccountStatusParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        assumeTrue("AccountStatusResponse.multicharactertraining is not included in class", TestControl.runBug());
        final AccountStatusParser accountStatusParser = new AccountStatusParser();
        prepareParser(accountStatusParser);

        final AccountStatusResponse response = accountStatusParser.getResponse(getAccount());

        testResponse(response);
    }

}
