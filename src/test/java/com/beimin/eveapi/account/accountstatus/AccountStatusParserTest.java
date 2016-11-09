package com.beimin.eveapi.account.accountstatus;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.Calendar;

import org.junit.Test;

import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.account.AccountStatusParser;
import com.beimin.eveapi.response.account.AccountStatusResponse;
import com.beimin.eveapi.utils.FullAuthParserTest;
import com.beimin.eveapi.utils.GMTConverter;

public class AccountStatusParserTest extends FullAuthParserTest {
    public AccountStatusParserTest() {
        super(ApiPath.ACCOUNT, ApiPage.ACCOUNT_STATUS);
    }

    @Test
    public void getResponse() throws Exception {
        final AccountStatusParser accountStatusParser = new AccountStatusParser();
        final AccountStatusResponse response = accountStatusParser.getResponse(auth);
        assertThat(response, notNullValue());
        Calendar cal = Calendar.getInstance(GMTConverter.DEFAULT_TIMEZONE);
        cal.set(Calendar.MILLISECOND, 0);
        cal.set(2011, 2, 13, 18, 40, 0);
        assertThat(response.getPaidUntil(), equalTo(cal.getTime()));
        cal.set(2004, 6, 22, 23, 54, 0);
        assertThat(response.getCreateDate(), equalTo(cal.getTime()));
        assertThat(response.getLogonCount(), equalTo(5603));
        assertThat(response.getLogonMinutes(), equalTo(504903));
    }
}
