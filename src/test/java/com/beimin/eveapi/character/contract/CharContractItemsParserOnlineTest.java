package com.beimin.eveapi.character.contract;

import java.util.List;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.model.shared.Contract;
import com.beimin.eveapi.model.shared.ContractType;
import com.beimin.eveapi.parser.character.CharContractItemsParser;
import com.beimin.eveapi.parser.character.CharContractsParser;
import com.beimin.eveapi.response.shared.ContractItemsResponse;
import com.beimin.eveapi.response.shared.ContractsResponse;

public class CharContractItemsParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        allowNull("getDateAccepted"); // Not accepted yet
        allowNull("getDateCompleted"); // Not completed yet
        allowNull("getRawQuantity"); // Never returned by the API (API BUG)
        final CharContractsParser contractsParser = new CharContractsParser();
        final ContractsResponse contractsResponse = contractsParser.getResponse(getCharacter());
        final List<Contract> contracts = contractsResponse.getAll();
        test(contracts);

        final CharContractItemsParser parser = new CharContractItemsParser();
        prepareParser(parser);
        for (final Contract contract : contracts) {
            if (contract.getType() == ContractType.COURIER) {
                continue;
            }
            if (contract.getType() == ContractType.LOAN) {
                continue;
            }

            final ContractItemsResponse response = parser.getResponse(getCharacter(), contract.getContractID());

            testResponse(response);
        }
    }

}
