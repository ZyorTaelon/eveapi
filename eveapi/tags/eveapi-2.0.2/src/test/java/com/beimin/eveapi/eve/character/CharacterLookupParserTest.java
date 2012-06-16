package com.beimin.eveapi.eve.character;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Collection;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.beimin.eveapi.eve.character.ApiCharacterLookup;
import com.beimin.eveapi.eve.character.CharacterLookupParser;

public class CharacterLookupParserTest {
	
	@Test
	public void testName2IdConversion() throws IOException, SAXException{
		CharacterLookupParser parser = CharacterLookupParser.getName2IdInstance();
		Collection<ApiCharacterLookup> chars = parser.getCharacterList("CCP Garthagk");
		assertEquals(1, chars.size());
		ApiCharacterLookup garthagk = chars.iterator().next();
		long characterID = garthagk.getCharacterID();
		assertEquals(797400947, characterID);
	}
	
	@Test
	public void testId2NameConversion() throws IOException, SAXException{
		CharacterLookupParser parser = CharacterLookupParser.getId2NameInstance();
		Collection<ApiCharacterLookup> chars = parser.getCharacterList(797400947);
		assertEquals(1, chars.size());
		ApiCharacterLookup garthagk = chars.iterator().next();
		String name = garthagk.getName();
		assertEquals("CCP Garthagk", name);
	}
}
