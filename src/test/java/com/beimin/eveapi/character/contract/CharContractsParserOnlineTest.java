package com.beimin.eveapi.character.contract;


import com.beimin.eveapi.AbstractOnlineTest;

import org.junit.Test;

import com.beimin.eveapi.parser.pilot.ContractsParser;
import com.beimin.eveapi.response.shared.ContractsResponse;

public class CharContractsParserOnlineTest extends AbstractOnlineTest {

	@Test
	public void getResponse() throws Exception {
		addNullOk("getDateAccepted"); //Not accepted yet
		addNullOk("getDateCompleted"); //Not completed yet
		addNullOk("getRawQuantity"); //Never returned by the API (API BUG)
		ContractsParser parser = new ContractsParser();
		ContractsResponse response = parser.getResponse(getPilot()); 
		testResponse(response);
	}

}