package com.beimin.eveapi.utils.character;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Collection;

import org.junit.Test;
import org.xml.sax.SAXException;

public class ParserTest {
	
	@Test
	public void testName2IdConversion() throws IOException, SAXException{
		Parser parser = Parser.getName2IdInstance();
		Response characterList = parser.getCharacterList("CCP Garthagk");
		Collection<ApiCharacterLookup> chars = characterList.getCharacterLookups();
		assertEquals(1, chars.size());
		ApiCharacterLookup garthagk = chars.iterator().next();
		long characterID = garthagk.getCharacterID();
		assertEquals(797400947, characterID);
	}
	
	@Test
	public void testId2NameConversion() throws IOException, SAXException{
		Parser parser = Parser.getId2NameInstance();
		Response characterList = parser.getCharacterList(797400947);
		Collection<ApiCharacterLookup> chars = characterList.getCharacterLookups();
		assertEquals(1, chars.size());
		ApiCharacterLookup garthagk = chars.iterator().next();
		String name = garthagk.getName();
		assertEquals("CCP Garthagk", name);
	}
}
