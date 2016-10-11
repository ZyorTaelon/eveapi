package com.beimin.eveapi.corporation.contract;

import java.util.Set;

import org.junit.Ignore;
import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.model.shared.Contract;
import com.beimin.eveapi.model.shared.ContractType;
import com.beimin.eveapi.parser.corporation.CorpContractItemsParser;
import com.beimin.eveapi.parser.corporation.CorpContractsParser;
import com.beimin.eveapi.response.shared.ContractItemsResponse;
import com.beimin.eveapi.response.shared.ContractsResponse;

public class CorpContractItemsParserOnlineTest extends AbstractOnlineTest {

    @Test @Ignore("No data returned by the API")
    public void getResponse() throws Exception {
        addNullOk("getDateAccepted"); // Not accepted yet
        addNullOk("getDateCompleted"); // Not completed yet
        addNullOk("getRawQuantity"); // Never returned by the API (API BUG)
        final CorpContractsParser contractsParser = new CorpContractsParser();
        final ContractsResponse contractsResponse = contractsParser.getResponse(getCorp());
        final Set<Contract> contracts = contractsResponse.getAll();
        test(contracts);
        final CorpContractItemsParser parser = new CorpContractItemsParser();
        prepareParser(parser);
        for (final Contract contract : contracts) {
            if (contract.getType() == ContractType.COURIER) {
                continue;
            }
            if (contract.getType() == ContractType.LOAN) {
                continue;
            }

            final ContractItemsResponse response = parser.getResponse(getCorp(), contract.getContractID());
            testResponse(response);
        }
    }

}
