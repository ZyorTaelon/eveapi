package com.beimin.eveapi.character.contract;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.pilot.ContractBidsParser;
import com.beimin.eveapi.response.shared.ContractBidsResponse;

public class CharContractBidsParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        final ContractBidsParser parser = new ContractBidsParser();
        final ContractBidsResponse response = parser.getResponse(getPilot());
        testResponse(response);
    }

}