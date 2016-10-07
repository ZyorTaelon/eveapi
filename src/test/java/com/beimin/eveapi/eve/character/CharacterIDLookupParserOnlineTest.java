package com.beimin.eveapi.eve.character;


import com.beimin.eveapi.AbstractOnlineTest;

import org.junit.Test;

import com.beimin.eveapi.parser.eve.CharacterLookupParser;
import com.beimin.eveapi.response.eve.CharacterLookupResponse;

public class CharacterIDLookupParserOnlineTest extends AbstractOnlineTest {

	@Test
	public void getResponse() throws Exception {
		CharacterLookupParser parser = CharacterLookupParser.getName2IdInstance();
		CharacterLookupResponse response = parser.getResponse(getCharacterName());
		testResponse(response);
	}

}