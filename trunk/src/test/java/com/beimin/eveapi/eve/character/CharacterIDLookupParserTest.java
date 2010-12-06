package com.beimin.eveapi.eve.character;

import static org.junit.Assert.assertEquals;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;


import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.utils.NoAuthParserTest;

public class CharacterIDLookupParserTest extends NoAuthParserTest {
	public CharacterIDLookupParserTest() {
		super(ApiPath.EVE, ApiPage.CHARACTER_ID);
	}

	@Test
	public void getResponse() throws ApiException {
		CharacterLookupParser parser = CharacterLookupParser.getName2IdInstance();
		CharacterLookupResponse response = parser.getResponse("CCP Garthagk");
		Collection<ApiCharacterLookup> chars = response.getCharacterLookups();
		assertEquals(1, chars.size());
		ApiCharacterLookup garthagk = chars.iterator().next();
		assertEquals("CCP Garthagk", garthagk.getName());
		assertEquals(797400947, garthagk.getCharacterID());
	}

	@Override
	protected void extraAsserts(HttpServletRequest req) {
		assertEquals("CCP Garthagk", req.getParameter("names"));
	}
}