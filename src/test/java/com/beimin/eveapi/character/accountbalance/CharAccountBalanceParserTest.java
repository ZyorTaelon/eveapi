package com.beimin.eveapi.character.accountbalance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Set;

import org.junit.Test;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.model.shared.AccountBalance;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.character.CharAccountBalanceParser;
import com.beimin.eveapi.response.shared.AccountBalanceResponse;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class CharAccountBalanceParserTest extends FullAuthParserTest {
    public CharAccountBalanceParserTest() {
        super(ApiPath.CHARACTER, ApiPage.ACCOUNT_BALANCE);
    }

    @Test
    public void getResponse() throws ApiException {
        final CharAccountBalanceParser parser = new CharAccountBalanceParser();
        final AccountBalanceResponse response = parser.getResponse(auth);
        assertNotNull(response);
        final Set<AccountBalance> accountBalances = response.getAll();
        assertNotNull(accountBalances);
        assertEquals(1, accountBalances.size());
        final AccountBalance accountBalance = accountBalances.iterator().next();
        assertEquals(10094361, accountBalance.getAccountID());
        assertEquals(1000, accountBalance.getAccountKey());
        assertEquals(46634844.84, accountBalance.getBalance(), 0.00001);
    }
}
