package com.beimin.eveapi.corporation.contract;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.corporation.ContractBidsParser;
import com.beimin.eveapi.response.shared.ContractBidsResponse;

public class CorpContractBidsParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        final ContractBidsParser parser = new ContractBidsParser();
        final ContractBidsResponse response = parser.getResponse(getCorp());
        testResponse(response);
    }

}
