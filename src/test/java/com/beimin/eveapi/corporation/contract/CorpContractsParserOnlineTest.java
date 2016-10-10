package com.beimin.eveapi.corporation.contract;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.corporation.CorpContractsParser;
import com.beimin.eveapi.response.shared.ContractsResponse;
import org.junit.Ignore;

public class CorpContractsParserOnlineTest extends AbstractOnlineTest {

    @Test @Ignore("No data returned by the API")
    public void getResponse() throws Exception {
        final CorpContractsParser parser = new CorpContractsParser();
        final ContractsResponse response = parser.getResponse(getCorp());
        testResponse(response);
    }

}
