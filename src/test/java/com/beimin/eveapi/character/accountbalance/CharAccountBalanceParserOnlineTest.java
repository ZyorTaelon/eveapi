package com.beimin.eveapi.character.accountbalance;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.pilot.CharAccountBalanceParser;
import com.beimin.eveapi.response.shared.AccountBalanceResponse;

public class CharAccountBalanceParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        final CharAccountBalanceParser parser = new CharAccountBalanceParser();
        final AccountBalanceResponse response = parser.getResponse(getPilot());
        testResponse(response);
    }

}
