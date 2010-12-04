package com.beimin.eveapi.eve.character;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.beimin.eveapi.ApiPage;
import com.beimin.eveapi.ApiPath;
import com.beimin.eveapi.utils.NoAuthParserTest;

public class CharacterNameLookupParserTest extends NoAuthParserTest {
	public CharacterNameLookupParserTest() {
		super(ApiPath.EVE, ApiPage.CHARACTER_NAME);
	}

	@Test
	public void getResponse() throws IOException, SAXException {
		CharacterLookupParser parser = CharacterLookupParser.getId2NameInstance();
		CharacterLookupResponse response = parser.getResponse(797400947);
		Collection<ApiCharacterLookup> chars = response.getCharacterLookups();
		assertEquals(1, chars.size());
		ApiCharacterLookup garthagk = chars.iterator().next();
		assertEquals("CCP Garthagk", garthagk.getName());
		assertEquals(797400947, garthagk.getCharacterID());
	}

	@Override
	protected void extraAsserts(HttpServletRequest req) {
		assertEquals("797400947", req.getParameter("ids"));
	}
}