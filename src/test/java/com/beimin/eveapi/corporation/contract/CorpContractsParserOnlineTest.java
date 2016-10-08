package com.beimin.eveapi.corporation.contract;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.corporation.ContractsParser;
import com.beimin.eveapi.response.shared.ContractsResponse;

public class CorpContractsParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        final ContractsParser parser = new ContractsParser();
        final ContractsResponse response = parser.getResponse(getCorp());
        testResponse(response);
    }

}
