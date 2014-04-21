package com.beimin.eveapi.eve.character;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.Map;

import org.junit.Test;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.model.eve.CharacterLookup;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.eve.CharacterLookupParser;
import com.beimin.eveapi.response.eve.CharacterLookupResponse;
import com.beimin.eveapi.utils.NoAuthParserTest;

public class CharacterNameLookupParserTest extends NoAuthParserTest {
	public CharacterNameLookupParserTest() {
		super(ApiPath.EVE, ApiPage.CHARACTER_NAME);
	}

	@Test
	public void getResponse() throws ApiException {
		CharacterLookupParser parser = CharacterLookupParser.getId2NameInstance();
		CharacterLookupResponse response = parser.getResponse(797400947);
		Collection<CharacterLookup> chars = response.getAll();
		assertEquals(1, chars.size());
		CharacterLookup garthagk = chars.iterator().next();
		assertEquals("CCP Garthagk", garthagk.getName());
		assertEquals(797400947, garthagk.getCharacterID());
	}

	@Override
	public void extraAsserts(Map<String, String> req) {
		super.extraAsserts(req);
		assertEquals("797400947", req.get("ids"));
	}
}