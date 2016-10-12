package com.beimin.eveapi.corporation.contract;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.TestControl;
import com.beimin.eveapi.parser.corporation.CorpContractBidsParser;
import com.beimin.eveapi.response.shared.ContractBidsResponse;
import static org.junit.Assume.assumeTrue;

public class CorpContractBidsParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        assumeTrue("No data returned by the API", TestControl.runNoData());
        final CorpContractBidsParser parser = new CorpContractBidsParser();
        prepareParser(parser);

        final ContractBidsResponse response = parser.getResponse(getCorp());

        testResponse(response);
    }

}
