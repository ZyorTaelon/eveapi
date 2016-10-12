package com.beimin.eveapi.corporation.contract;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.TestControl;
import com.beimin.eveapi.parser.corporation.CorpContractsParser;
import com.beimin.eveapi.response.shared.ContractsResponse;
import static org.junit.Assume.assumeTrue;

public class CorpContractsParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        assumeTrue("No data returned by the API", TestControl.runNoData());
        final CorpContractsParser parser = new CorpContractsParser();
        prepareParser(parser);

        final ContractsResponse response = parser.getResponse(getCorp());

        testResponse(response);
    }

}
