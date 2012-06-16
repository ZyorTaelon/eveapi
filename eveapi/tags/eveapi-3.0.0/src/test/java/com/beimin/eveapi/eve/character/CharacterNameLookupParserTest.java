package com.beimin.eveapi.eve.character;

import static org.junit.Assert.assertEquals;

import java.util.Collection;


import org.junit.Test;


import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.utils.NoAuthParserTest;
import java.util.Map;

public class CharacterNameLookupParserTest extends NoAuthParserTest {
	public CharacterNameLookupParserTest() {
		super(ApiPath.EVE, ApiPage.CHARACTER_NAME);
	}

	@Test
	public void getResponse() throws ApiException {
		CharacterLookupParser parser = CharacterLookupParser.getId2NameInstance();
		CharacterLookupResponse response = parser.getResponse(797400947);
		Collection<ApiCharacterLookup> chars = response.getCharacterLookups();
		assertEquals(1, chars.size());
		ApiCharacterLookup garthagk = chars.iterator().next();
		assertEquals("CCP Garthagk", garthagk.getName());
		assertEquals(797400947, garthagk.getCharacterID());
	}

	@Override
	public void extraAsserts(Map<String, String> req) {
		super.extraAsserts(req);
		assertEquals("797400947", req.get("ids"));
	}
}