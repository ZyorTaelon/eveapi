package com.beimin.eveapi.character.contract;

import java.util.Set;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.TestControl;
import com.beimin.eveapi.model.shared.Contract;
import com.beimin.eveapi.model.shared.ContractType;
import com.beimin.eveapi.parser.pilot.CharContractItemsParser;
import com.beimin.eveapi.parser.pilot.CharContractsParser;
import com.beimin.eveapi.response.shared.ContractItemsResponse;
import com.beimin.eveapi.response.shared.ContractsResponse;
import static org.junit.Assume.assumeTrue;

public class CharContractItemsParserOnlineTest extends AbstractOnlineTest {

    @Test
    public void getResponse() throws Exception {
        assumeTrue("No data returned by the API", TestControl.runNoData());
        addNullOk("getDateAccepted"); // Not accepted yet
        addNullOk("getDateCompleted"); // Not completed yet
        addNullOk("getRawQuantity"); // Never returned by the API (API BUG)
        final CharContractsParser contractsParser = new CharContractsParser();
        final ContractsResponse contractsResponse = contractsParser.getResponse(getCharacter());
        final Set<Contract> contracts = contractsResponse.getAll();
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
