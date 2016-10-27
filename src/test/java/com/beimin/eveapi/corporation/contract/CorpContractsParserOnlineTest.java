package com.beimin.eveapi.corporation.contract;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.corporation.CorpContractsParser;
import com.beimin.eveapi.response.shared.ContractsResponse;

public class CorpContractsParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        setAlias(ContractsResponse.class, "contractList", "items");
        allowNull("getDateCompleted"); //Not completed
        allowEmpty("getPrice"); //Zero is a valid value
        allowEmpty("getBuyout"); //Zero is a valid value
        final CorpContractsParser parser = new CorpContractsParser();
        prepareParser(parser);

        final ContractsResponse response = parser.getResponse(getCorp());

        testResponse(response);
    }

}
