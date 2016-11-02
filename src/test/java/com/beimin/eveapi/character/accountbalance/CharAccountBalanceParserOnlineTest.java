package com.beimin.eveapi.character.accountbalance;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.character.CharAccountBalanceParser;
import com.beimin.eveapi.response.shared.AccountBalanceResponse;

public class CharAccountBalanceParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        setAlias(AccountBalanceResponse.class, "accounts", "items");
        final CharAccountBalanceParser parser = new CharAccountBalanceParser();
        prepareParser(parser);

        final AccountBalanceResponse response = parser.getResponse(getCharacter());

        testResponse(response);
    }

}
