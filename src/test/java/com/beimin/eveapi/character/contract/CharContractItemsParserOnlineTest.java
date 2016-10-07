package com.beimin.eveapi.character.contract;

import java.util.Set;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.model.shared.Contract;
import com.beimin.eveapi.model.shared.ContractType;
import com.beimin.eveapi.parser.pilot.ContractItemsParser;
import com.beimin.eveapi.parser.pilot.ContractsParser;
import com.beimin.eveapi.response.shared.ContractItemsResponse;
import com.beimin.eveapi.response.shared.ContractsResponse;

public class CharContractItemsParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        addNullOk("getDateAccepted"); // Not accepted yet
        addNullOk("getDateCompleted"); // Not completed yet
        addNullOk("getRawQuantity"); // Never returned by the API (API BUG)
        final ContractsParser contractsParser = new ContractsParser();
        final ContractsResponse contractsResponse = contractsParser.getResponse(getPilot());
        testResponse(contractsResponse);
        final Set<Contract> contracts = contractsResponse.getAll();
        test(contracts);
        for (final Contract contract : contracts) {
            if (contract.getType() == ContractType.COURIER) {
                continue;
            }
            if (contract.getType() == ContractType.LOAN) {
                continue;
            }
            final ContractItemsParser parser = new ContractItemsParser();
            final ContractItemsResponse response = parser.getResponse(getPilot(), contract.getContractID());
            testResponse(response);
        }
    }

}