package com.beimin.eveapi.account.accountstatus;

import static com.beimin.eveapi.utils.Assert.assertDate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.beimin.eveapi.model.account.AccountStatus;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.account.AccountStatusParser;
import com.beimin.eveapi.response.account.AccountStatusResponse;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class AccountStatusParserTest extends FullAuthParserTest {
    public AccountStatusParserTest() {
        super(ApiPath.ACCOUNT, ApiPage.ACCOUNT_STATUS);
    }

    @Test
    public void getResponse() throws Exception {
        final AccountStatusParser accountStatusParser = new AccountStatusParser();
        final AccountStatusResponse response = accountStatusParser.getResponse(auth);
        assertNotNull(response);
        final AccountStatus accountStatus = response.get();
        assertDate(2011, 03, 13, 18, 40, 0, accountStatus.getPaidUntil());
        assertDate(2004, 07, 22, 23, 54, 0, accountStatus.getCreateDate());
        assertEquals(5603, accountStatus.getLogonCount());
        assertEquals(504903, accountStatus.getLogonMinutes());
    }
}
