package com.beimin.eveapi.character.accountbalance;


import com.beimin.eveapi.AbstractOnlineTest;

import org.junit.Test;

import com.beimin.eveapi.parser.pilot.PilotAccountBalanceParser;
import com.beimin.eveapi.response.shared.AccountBalanceResponse;

public class CharAccountBalanceParserOnlineTest extends AbstractOnlineTest {

	@Test
	public void getResponse() throws Exception {
		PilotAccountBalanceParser parser = new PilotAccountBalanceParser();
		AccountBalanceResponse response = parser.getResponse(getPilot());
		testResponse(response);
	}

}