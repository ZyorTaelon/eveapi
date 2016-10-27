package com.beimin.eveapi.character.contract;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.pilot.CharContractsParser;
import com.beimin.eveapi.response.shared.ContractsResponse;

public class CharContractsParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        setAlias(ContractsResponse.class, "contractList", "items");
        allowNull("getDateAccepted"); // Not accepted yet
        allowEmpty("getAcceptorID"); // Not accepted yet
        allowNull("getDateCompleted"); // Not completed yet
        allowNull("getRawQuantity"); // Never returned by the API (API BUG)
        allowEmpty("getBuyout"); // No buyout
        allowEmpty("getReward"); // No reward
        allowEmpty("getCollateral"); // No collateral
        allowEmpty("getNumDays"); // Not courier
        allowEmpty("getPrice"); // No price
        allowEmpty("getTitle"); // No title
        final CharContractsParser parser = new CharContractsParser();
        prepareParser(parser);

        final ContractsResponse response = parser.getResponse(getCharacter());

        testResponse(response);
    }

}
