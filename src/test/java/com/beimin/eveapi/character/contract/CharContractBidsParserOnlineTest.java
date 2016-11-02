package com.beimin.eveapi.character.contract;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.character.CharContractBidsParser;
import com.beimin.eveapi.response.shared.ContractBidsResponse;

public class CharContractBidsParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        setAlias(ContractBidsResponse.class, "bidList", "items");
        final CharContractBidsParser parser = new CharContractBidsParser();
        prepareParser(parser);

        final ContractBidsResponse response = parser.getResponse(getCharacter());

        testResponse(response);
    }

}
