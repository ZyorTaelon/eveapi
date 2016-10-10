package com.beimin.eveapi.character.contract;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.pilot.CharContractBidsParser;
import com.beimin.eveapi.response.shared.ContractBidsResponse;
import org.junit.Ignore;

public class CharContractBidsParserOnlineTest extends AbstractOnlineTest {

    @Test @Ignore("No data returned by the API")
    public void getResponse() throws Exception {
        final CharContractBidsParser parser = new CharContractBidsParser();
        final ContractBidsResponse response = parser.getResponse(getPilot());
        testResponse(response);
    }

}
