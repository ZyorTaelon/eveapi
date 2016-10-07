package com.beimin.eveapi.character.contract;


import com.beimin.eveapi.AbstractOnlineTest;

import org.junit.Test;

import com.beimin.eveapi.model.shared.Contract;
import com.beimin.eveapi.model.shared.ContractType;
import com.beimin.eveapi.parser.pilot.ContractItemsParser;
import com.beimin.eveapi.parser.pilot.ContractsParser;
import com.beimin.eveapi.response.shared.ContractItemsResponse;
import com.beimin.eveapi.response.shared.ContractsResponse;
import java.util.Set;

public class CharContractItemsParserOnlineTest extends AbstractOnlineTest {

	@Test
	public void getResponse() throws Exception {
		addNullOk("getDateAccepted"); //Not accepted yet
		addNullOk("getDateCompleted"); //Not completed yet
		addNullOk("getRawQuantity"); //Never returned by the API (API BUG)
		ContractsParser contractsParser = new ContractsParser();
		ContractsResponse contractsResponse = contractsParser.getResponse(getPilot());
		testResponse(contractsResponse);
		Set<Contract> contracts = contractsResponse.getAll();
		test(contracts);
		for (Contract contract : contracts) {
			if (contract.getType() == ContractType.COURIER) {
				continue;
			}
			if (contract.getType() == ContractType.LOAN) {
				continue;
			}
			ContractItemsParser parser = new ContractItemsParser();
			ContractItemsResponse response = parser.getResponse(getPilot(), contract.getContractID()); 
			testResponse(response);
		}
	}

}