package com.beimin.eveapi.eve.character;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Collection;

import org.junit.Test;
import org.xml.sax.SAXException;

public class CharacterLookupParserTest {
	private static final int CHAR_ID = 797400947;
	private static final String NAME = "CCP Garthagk";

	@Test
	public void testName2IdConversion() throws IOException, SAXException {
		CharacterLookupParser parser = CharacterLookupParser
				.getName2IdInstance();
		CharacterLookupResponse response = parser.getCharacterList(NAME);
		Collection<ApiCharacterLookup> chars = response.getCharacterLookups();
		assertEquals(1, chars.size());
		ApiCharacterLookup garthagk = chars.iterator().next();
		long characterID = garthagk.getCharacterID();
		assertEquals(CHAR_ID, characterID);
	}

	@Test
	public void testId2NameConversion() throws IOException, SAXException {
		CharacterLookupParser parser = CharacterLookupParser
				.getId2NameInstance();
		CharacterLookupResponse response = parser.getCharacterList(CHAR_ID);
		Collection<ApiCharacterLookup> chars = response.getCharacterLookups();
		assertEquals(1, chars.size());
		ApiCharacterLookup garthagk = chars.iterator().next();
		String name = garthagk.getName();
		assertEquals(NAME, name);
	}
}