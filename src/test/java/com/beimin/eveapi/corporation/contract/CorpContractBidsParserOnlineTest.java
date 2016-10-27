package com.beimin.eveapi.corporation.contract;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.corporation.CorpContractBidsParser;
import com.beimin.eveapi.response.shared.ContractBidsResponse;

public class CorpContractBidsParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        setAlias(ContractBidsResponse.class, "bidList", "items");
        final CorpContractBidsParser parser = new CorpContractBidsParser();
        prepareParser(parser);

        final ContractBidsResponse response = parser.getResponse(getCorp());

        testResponse(response);
    }

}
