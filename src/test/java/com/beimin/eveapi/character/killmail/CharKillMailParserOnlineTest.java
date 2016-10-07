package com.beimin.eveapi.character.killmail;

import com.beimin.eveapi.AbstractOnlineTest;


import org.junit.Test;

import com.beimin.eveapi.parser.pilot.KillMailParser;
import com.beimin.eveapi.parser.shared.AbstractKillMailParser;
import com.beimin.eveapi.response.shared.KillMailResponse;

public class CharKillMailParserOnlineTest extends AbstractOnlineTest {

	@Test
	public void getResponse() throws Exception {
		addEmptyOK("getAllianceName");
		addEmptyOK("getCharacterName"); // Concord officers don't have a character name ;-)
		addEmptyOK("getFactionName");
		AbstractKillMailParser parser = new KillMailParser();
		KillMailResponse response = parser.getResponse(getPilot());
		testResponse(response);

		testFail("Does not test KillMail walking");
	}

}

