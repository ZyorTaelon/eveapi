package com.beimin.eveapi.corporation.contract;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.corporation.CorpContractBidsParser;
import com.beimin.eveapi.response.shared.ContractBidsResponse;
import org.junit.Ignore;

public class CorpContractBidsParserOnlineTest extends AbstractOnlineTest {

    @Test @Ignore("No data returned by the API")
    public void getResponse() throws Exception {
        final CorpContractBidsParser parser = new CorpContractBidsParser();
        final ContractBidsResponse response = parser.getResponse(getCorp());
        testResponse(response);
    }

}
