package com.beimin.eveapi.character.contract;

import org.junit.Ignore;
import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.pilot.CharContractsParser;
import com.beimin.eveapi.response.shared.ContractsResponse;

public class CharContractsParserOnlineTest extends AbstractOnlineTest {

    @Test @Ignore("No data returned by the API")
    public void getResponse() throws Exception {
        addNullOk("getDateAccepted"); // Not accepted yet
        addNullOk("getDateCompleted"); // Not completed yet
        addNullOk("getRawQuantity"); // Never returned by the API (API BUG)
        final CharContractsParser parser = new CharContractsParser();
        prepareParser(parser);

        final ContractsResponse response = parser.getResponse(getCharacter());

        testResponse(response);
    }

}
