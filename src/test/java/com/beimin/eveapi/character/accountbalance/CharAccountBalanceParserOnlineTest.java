package com.beimin.eveapi.character.accountbalance;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.pilot.PilotAccountBalanceParser;
import com.beimin.eveapi.response.shared.AccountBalanceResponse;

public class CharAccountBalanceParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        final PilotAccountBalanceParser parser = new PilotAccountBalanceParser();
        final AccountBalanceResponse response = parser.getResponse(getPilot());
        testResponse(response);
    }

}